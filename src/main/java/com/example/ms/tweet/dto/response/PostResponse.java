package com.example.ms.tweet.dto.response;

import com.example.ms.tweet.dao.entity.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private LocalDateTime createdOn;
    private String createdBy;
    private List<TagEntity> tags;
}
