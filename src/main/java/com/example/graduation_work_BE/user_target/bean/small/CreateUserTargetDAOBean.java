package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetSaveDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CreateUserTargetDAOBean {

    public UserTargetDAO exec(RequestUserTargetSaveDTO requestUserTargetSaveDTO){
        return UserTargetDAO.builder()
                .userTargetId(UUID.randomUUID())
                .userId(requestUserTargetSaveDTO.getUserId())
                .targetContent(requestUserTargetSaveDTO.getTargetContent())
                .startTime(requestUserTargetSaveDTO.getStartTime())
                .endTime(requestUserTargetSaveDTO.getEndTime())
                .isFinish(false)
                .createAt(LocalDateTime.now())
                .uploadAt(LocalDateTime.now())
                .build();
    }

    public List<UserTargetDAO> exec(UUID userId, String aiResponseText) {
        // 응답 텍스트를 문단 단위로 분리하거나 "-"로 시작하는 라인 기준 분리
        String[] lines = aiResponseText.split("\\n");

        List<UserTargetDAO> userTargetDAOS = new ArrayList<>();

        for (String line : lines) {
            String trimmed = line.replaceFirst("^-\\s*", "").trim();
            if (trimmed.isEmpty()) continue;

            UserTargetDAO userTarget = UserTargetDAO.builder()
                    .userTargetId(UUID.randomUUID())
                    .userId(userId)
                    .targetContent(trimmed)
                    .isFinish(false)
                    .createAt(LocalDateTime.now())
                    .uploadAt(LocalDateTime.now())
                    .build();

            userTargetDAOS.add(userTarget);
        }

        return userTargetDAOS;
    }
}
