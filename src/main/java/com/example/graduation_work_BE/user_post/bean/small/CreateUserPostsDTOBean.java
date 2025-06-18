package com.example.graduation_work_BE.user_post.bean.small;

import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateUserPostsDTOBean {

    CreateUserPostDTOBean createUserPostDTOBean;

    @Autowired
    public CreateUserPostsDTOBean(CreateUserPostDTOBean createUserPostDTOBean){
        this.createUserPostDTOBean = createUserPostDTOBean;
    }

    public List<ResponseUserPostGetDTO> exec(List<UserPostDAO> userPostDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseUserPostGetDTO> responseUserPostGetDTOS = new ArrayList<>();

        // DAO리스트에서 값 한개씩 꺼내기
        for (UserPostDAO userPostDAO : userPostDAOS){

            // 유저포스트 DTO 생성
            ResponseUserPostGetDTO responseUserPostGetDTO = createUserPostDTOBean.exec(userPostDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseUserPostGetDTOS.add(responseUserPostGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseUserPostGetDTOS;
    }
}
