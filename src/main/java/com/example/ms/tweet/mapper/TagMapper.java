package com.example.ms.tweet.mapper;

import com.example.ms.tweet.dao.entity.TagEntity;
import com.example.ms.tweet.model.request.SaveTagDto;
import com.example.ms.tweet.model.response.TagResponse;

public class TagMapper {
    public static TagEntity buildTagEntity(SaveTagDto dto) {
        return TagEntity.builder()
                .name(dto.getName())
                .build();
    }
    public static TagResponse buildTagResponse(TagEntity tag) {
        return TagResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
