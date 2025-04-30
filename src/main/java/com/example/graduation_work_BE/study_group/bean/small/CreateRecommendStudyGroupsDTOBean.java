package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.ResponseRecommendStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateRecommendStudyGroupsDTOBean {
    public ResponseRecommendStudyGroupGetDTO exec(StudyGroupDAO studyGroupDAO){
        return ResponseRecommendStudyGroupGetDTO.builder()
                .studyGroupId(studyGroupDAO.getStudyGroupId())
                .studyGroupName(studyGroupDAO.getStudyGroupName())
                .techStacks(studyGroupDAO.getTechStacks())
                .description(studyGroupDAO.getDescription())
                .isRecruiting(studyGroupDAO.getIsRecruiting())
                .build();
    }

    public List<ResponseRecommendStudyGroupGetDTO> exec(List<StudyGroupDAO> studyGroupDAOS){

        // 빈 DTO 리스트 생성
        List<ResponseRecommendStudyGroupGetDTO> responseRecommendStudyGroupGetDTOS = new ArrayList<>();

        // DAO 리스트에서 값 한개씩 꺼내기
        for (StudyGroupDAO studyGroupDAO : studyGroupDAOS){

            // 스터디그룹 DTO 생성
            ResponseRecommendStudyGroupGetDTO responseRecommendStudyGroupGetDTO = exec(studyGroupDAO);

            // 생성한 DTO를 DTO 리스트에 넣기
            responseRecommendStudyGroupGetDTOS.add(responseRecommendStudyGroupGetDTO);
        }

        // 생성한 DTO 리스트 반환
        return responseRecommendStudyGroupGetDTOS;
    }
}
