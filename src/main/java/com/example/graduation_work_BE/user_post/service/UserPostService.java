package com.example.graduation_work_BE.user_post.service;

import com.example.graduation_work_BE.user_post.bean.GetUserPostBean;
import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_target.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserPostService {

    GetUserPostBean getUserPostBean;

    @Autowired
    public UserPostService(GetUserPostBean getUserPostBean){
        this.getUserPostBean = getUserPostBean;

    }

    // 특정 게시물 조회
    public ResponseUserPostGetDTO getUserPost(UUID userPostId){
        return getUserPostBean.exec(userPostId);
    }

    // 전체 게시물 조회


    // 게시물 저장


    // 게시물 수정



    // 게시물 삭제


}
