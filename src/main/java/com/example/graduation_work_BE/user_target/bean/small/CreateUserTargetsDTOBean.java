package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateUserTargetsDTOBean {

    CreateUserTargetDTOBean createUserTargetDTOBean;

    @Autowired
    public CreateUserTargetsDTOBean(CreateUserTargetDTOBean createUserTargetDTOBean){
        this.createUserTargetDTOBean = createUserTargetDTOBean;
    }

    public List<ResponseUserTargetGetDTO> exec(List<UserTargetDAO> userTargetDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseUserTargetGetDTO> responseUserTargetGetDTOS = new ArrayList<>();

        // DAO리스트에서 값 한개씩 꺼내기
        for (UserTargetDAO userTargetDAO : userTargetDAOS){

            // 유저스케줄 DTO 생성
            ResponseUserTargetGetDTO responseUserTargetGetDTO = createUserTargetDTOBean.exec(userTargetDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseUserTargetGetDTOS.add(responseUserTargetGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseUserTargetGetDTOS;
    }
}
