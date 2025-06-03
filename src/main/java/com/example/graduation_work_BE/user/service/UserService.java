package com.example.graduation_work_BE.user.service;

import com.example.graduation_work_BE.user.bean.GetUserBean;
import com.example.graduation_work_BE.user.bean.small.GetUserDAOBean;
import com.example.graduation_work_BE.user.bean.small.SaveUserDAOBean;
import com.example.graduation_work_BE.user.entity.DTO.ResponseUserGetDTO;
import com.example.graduation_work_BE.user.entity.UserDAO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private final Environment environment;
    private final RestTemplate restTemplate = new RestTemplate();

    GetUserDAOBean getUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;
    GetUserBean getUserBean;

    @Autowired
    public UserService(Environment environment, GetUserDAOBean getUserDAOBean, SaveUserDAOBean saveUserDAOBean, GetUserBean getUserBean){
        this.environment = environment;
        this.getUserDAOBean = getUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.getUserBean = getUserBean;
    }

    // 로그인
    public UUID socialLogin(String code, String registrationId){

        // registrationId 로 구분해 로그인 진행
        if(registrationId.equals("google")) return googleLogin(code);
        else return null;
    }

    // 구글로 로그인
    public UUID googleLogin(String code){

        // AuthorizationCode로 AccessToken을 발급 받음
        String accessToken = getAccessToken(code);

        // 발급 받은 accessToken으로 유저의 정보를 가져옴 : JsonNode 형태
        JsonNode userResourceNode = getUserResource(accessToken);

        // 확인용
        //System.out.println("userResourceNode = " + userResourceNode);

        // userResourseNode에서 id, email, name에 해당하는 값을 String으로 꺼내
        String oauthId = userResourceNode.get("id").asText();
        String nickname = userResourceNode.get("name").asText();
        String userImage = userResourceNode.get("picture").asText();

        UserDAO userDAO = getUserDAOBean.exec(oauthId);

        // oauthId가 이미 DB에 존재할 경우
        if(userDAO!=null){
            // 이미 회원가입된 유저라도 액세스 토큰은 새로 발급되기에 토큰 재설정
            userDAO.setAccessToken(accessToken);
        }
        else {
            // 존재하지 않을 경우 -> 회원가입
            // User(DAO)를 생성해서 값을 설정하고 save 해야겠지
            userDAO = new UserDAO();
            userDAO.setUserId(UUID.randomUUID());
            userDAO.setOauthId(oauthId);
            userDAO.setUserName(nickname);
            userDAO.setUserImage(userImage);
            userDAO.setAccessToken(accessToken);
        }

        // DAO 저장
        saveUserDAOBean.exec(userDAO);

        return userDAO.getUserId();
    }

    // AccessToken 발급 받기
    private String getAccessToken(String authorizationCode){


        // 설정해둔 Property들 가져와
        String clientId = environment.getProperty("google.client.id");
        String clientSecret = environment.getProperty("google.client.secret");
        String redirectUri = environment.getProperty("google.auth.redirect-uri");
        String tokenUri = environment.getProperty("google.auth.token-uri");

        log.info("✅ Google Client ID: {}", clientId);
        log.info("✅ Google Secret: {}", clientSecret);
        log.info("✅ Google Redirect URI: {}", redirectUri);

        // params라는 이름의 Map 생성해서 요청에 쓸 정보들 매핑해서 넣어
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        log.debug("Google client_id: {}", clientId);

        // 요청에 쓸 헤더 설정
        HttpHeaders headers =  new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // HttpEntity로 요청 본문 설정 : 위에서 정보 넣어둔 params, headers로 설정
        HttpEntity entity = new HttpEntity(params, headers);

        // restTemplate으로 요청 보냄 : 응답은 JsonNode로 구체화된 ResponseEntity!
        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);

        // 응답 노드의 바디에 accessToken 담겨 있으니 바디를 따로 노드로 저장
        JsonNode accessTokenNode = responseNode.getBody();

        // access_token get해서 String으로 변환, 리턴
        return accessTokenNode.get("access_token").asText();
    }

    // 유저 정보 가져오기
    private JsonNode getUserResource(String accessToken) {

        // 요청 보낼 리소스 서버 URI 가져옴
        String resourceUri = environment.getProperty("google.resource-uri");

        // 요청으로 보낼 헤더 설정 : accessToken 앞에 "Bearer"를 붙인 걸 Authorization 으로 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // 요청 본문 설정~
        HttpEntity entity = new HttpEntity(headers);

        // resourceUri로 요청 AccessToken 포함한 요청 보내, 응답으로 받은 유저 정보 getBody 해서 리턴
        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }

    // 유저 조회
    public ResponseUserGetDTO getUser(UUID userId){
        return getUserBean.exec(userId);
    }

}