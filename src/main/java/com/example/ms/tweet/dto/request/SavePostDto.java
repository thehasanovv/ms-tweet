package com.example.ms.tweet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePostDto {
    private String title;
    private String createdBy;
    private Set<Long> tagIds;
}
