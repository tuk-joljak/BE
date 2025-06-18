package com.example.graduation_work_BE.user_post.service;

import com.example.graduation_work_BE.user_post.bean.*;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostDeleteDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostSaveDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostUpdateDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserPostService {

    GetUserPostBean getUserPostBean;
    GetUserPostsBean getUserPostsBean;
    SaveUserPostBean saveUserPostBean;
    UpdateUserPostBean updateUserPostBean;
    DeleteUserPostBean deleteUserPostBean;

    @Autowired
    public UserPostService(GetUserPostBean getUserPostBean, GetUserPostsBean getUserPostsBean, SaveUserPostBean saveUserPostBean, UpdateUserPostBean updateUserPostBean, DeleteUserPostBean deleteUserPostBean){
        this.getUserPostBean = getUserPostBean;
        this.getUserPostsBean = getUserPostsBean;
        this.saveUserPostBean = saveUserPostBean;
        this.updateUserPostBean = updateUserPostBean;
        this.deleteUserPostBean = deleteUserPostBean;

    }

    // 특정 게시물 조회
    public ResponseUserPostGetDTO getUserPost(UUID userPostId){
        return getUserPostBean.exec(userPostId);
    }

    // 전체 게시물 조회
    public List<ResponseUserPostGetDTO> getUserPosts(UUID userId){
        return getUserPostsBean.exec(userId);
    }


    // 게시물 저장
    public UUID saveUserPost(RequestUserPostSaveDTO requestUserPostSaveDTO){
        return saveUserPostBean.exec(requestUserPostSaveDTO);
    }

    // 게시물 수정
    public UUID updateUserPost(RequestUserPostUpdateDTO requestUserPostUpdateDTO){
        return updateUserPostBean.exec(requestUserPostUpdateDTO);
    }


    // 게시물 삭제
    public UUID deleteUserPost(RequestUserPostDeleteDTO requestUserPostDeleteDTO){
        return deleteUserPostBean.exec(requestUserPostDeleteDTO);
    }


}
