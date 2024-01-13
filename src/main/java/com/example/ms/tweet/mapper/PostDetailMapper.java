package com.example.ms.tweet.mapper;

import com.example.ms.tweet.dao.entity.PostDetailEntity;
import com.example.ms.tweet.dao.entity.PostEntity;

public class PostDetailMapper {
    public static PostDetailEntity buildPostDetailEntity(PostEntity post, String createdBy) {
        return PostDetailEntity.builder()
                .post(post)
                .createdBy(createdBy)
                .build();
    }
}
