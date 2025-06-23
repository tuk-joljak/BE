package com.example.graduation_work_BE.user.bean;

import com.example.graduation_work_BE.user.bean.small.CreateUserDAOBean;
import com.example.graduation_work_BE.user.bean.small.GetMainUserDAOBean;
import com.example.graduation_work_BE.user.bean.small.SaveMainUserDAOBean;
import com.example.graduation_work_BE.user.entity.DTO.RequestMainUserSaveDTO;
import com.example.graduation_work_BE.user.entity.MainUserDAO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveMainUserBean {

    CreateUserDAOBean createUserDAOBean;
    SaveMainUserDAOBean saveMainUserDAOBean;

    @Autowired
    public SaveMainUserBean(CreateUserDAOBean createUserDAOBean, SaveMainUserDAOBean saveMainUserDAOBean) {
        this.createUserDAOBean = createUserDAOBean;
        this.saveMainUserDAOBean = saveMainUserDAOBean;
    }

    public UUID exec(RequestMainUserSaveDTO requestMainUserSaveDTO){

        // 사용자 정보 조회
        MainUserDAO mainUserDAO = createUserDAOBean.exec(requestMainUserSaveDTO);

        saveMainUserDAOBean.exec(mainUserDAO);

        return mainUserDAO.getMainUserId();
    }
}
