package com.example.ms.tweet.mapper;

import com.example.ms.tweet.dao.entity.PostEntity;
import com.example.ms.tweet.model.request.SavePostDto;
import com.example.ms.tweet.model.response.PostResponse;

public class PostMapper {

    public static PostEntity buildPostEntity(SavePostDto dto) {
        return PostEntity.builder()
                .title(dto.getTitle())
                .build();
    }

    public static PostResponse buildPostResponse(PostEntity post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .createdOn(post.getDetail().getCreatedOn())
                .createdBy(post.getDetail().getCreatedBy())
                .tags(post.getTags().stream().toList())
                .build();
    }
}
