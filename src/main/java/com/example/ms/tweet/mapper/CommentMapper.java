package com.example.ms.tweet.mapper;

import com.example.ms.tweet.dao.entity.CommentEntity;
import com.example.ms.tweet.dao.entity.PostEntity;
import com.example.ms.tweet.dto.response.CommentResponse;

public class CommentMapper {
    public static CommentEntity buildCommentEntity(PostEntity post, String content) {
        return CommentEntity.builder()
                .post(post)
                .content(content)
                .build();
    }

    public static CommentResponse buildCommentResponse(CommentEntity entity){
        return CommentResponse.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .viewed(entity.isViewed())
                .build();
    }
}
