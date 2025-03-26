package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateUserSchedulesDTOBean {

    CreateUserScheduleDTOBean createUserScheduleDTOBean;

    @Autowired
    public CreateUserSchedulesDTOBean(CreateUserScheduleDTOBean createUserScheduleDTOBean){
        this.createUserScheduleDTOBean = createUserScheduleDTOBean;
    }

    public List<ResponseUserScheduleGetDTO> exec(List<UserScheduleDAO> userScheduleDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseUserScheduleGetDTO> responseUserScheduleGetDTOS = new ArrayList<>();

        // DAO리스트에서 값 한개씩 꺼내기
        for (UserScheduleDAO userScheduleDAO : userScheduleDAOS){

            // 유저스케줄 DTO 생성
            ResponseUserScheduleGetDTO responseUserScheduleGetDTO = createUserScheduleDTOBean.exec(userScheduleDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseUserScheduleGetDTOS.add(responseUserScheduleGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseUserScheduleGetDTOS;
    }
}
