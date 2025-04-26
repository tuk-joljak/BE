package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateStudyGroupsDTOBean {

    CreateStudyGroupDTOBean createStudyGroupDTOBean;

    @Autowired
    public CreateStudyGroupsDTOBean(CreateStudyGroupDTOBean createStudyGroupDTOBean){
        this.createStudyGroupDTOBean = createStudyGroupDTOBean;
    }

    public List<ResponseStudyGroupGetDTO> exec(List<StudyGroupDAO> studyGroupDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseStudyGroupGetDTO> responseStudyGroupGetDTOS = new ArrayList<>();

        // DAO 리스트에서 값 한개씩 꺼내기
        for (StudyGroupDAO studyGroupDAO : studyGroupDAOS){

            // 스터디그룹 DTO 생성
            ResponseStudyGroupGetDTO responseStudyGroupGetDTO = createStudyGroupDTOBean.exec(studyGroupDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseStudyGroupGetDTOS.add(responseStudyGroupGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseStudyGroupGetDTOS;
    }
}
