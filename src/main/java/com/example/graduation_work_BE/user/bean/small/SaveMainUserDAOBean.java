package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.MainUserDAO;
import com.example.graduation_work_BE.user.repository.MainUserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMainUserDAOBean {

    MainUserRepositoryJPA mainUserRepositoryJPA;

    @Autowired
    public SaveMainUserDAOBean(MainUserRepositoryJPA mainUserRepositoryJPA) {
        this.mainUserRepositoryJPA = mainUserRepositoryJPA;
    }

    // 사용자 정보 저장
    public void exec(MainUserDAO mainUserDAO) {
        mainUserRepositoryJPA.save(mainUserDAO);
    }
}
