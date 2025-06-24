package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyParticipantGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateStudyParticipantDTOBean {

    public List<ResponseStudyParticipantGetDTO> exec(List<StudyParticipantDAO> studyParticipantDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseStudyParticipantGetDTO> responseStudyParticipantGetDTOS = new ArrayList<>();

        // DAO 리스트에서 값 한개씩 꺼내기
        for (StudyParticipantDAO studyParticipantDAO : studyParticipantDAOS){

            // 스터디그룹원 DTO 생성
            ResponseStudyParticipantGetDTO responseStudyParticipantGetDTO = exec(studyParticipantDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseStudyParticipantGetDTOS.add(responseStudyParticipantGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseStudyParticipantGetDTOS;
        }

    // StudyParticipantDAO 하나 → DTO 하나로
    public ResponseStudyParticipantGetDTO exec(StudyParticipantDAO studyParticipantDAO) {
        return ResponseStudyParticipantGetDTO.builder()
                .studyParticipantId(studyParticipantDAO.getStudyParticipantId())
                .userId(studyParticipantDAO.getUserId())
                .build();
    }

}
