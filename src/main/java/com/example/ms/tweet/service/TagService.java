package com.example.ms.tweet.service;

import com.example.ms.tweet.dao.entity.TagEntity;
import com.example.ms.tweet.dao.repository.TagRepository;
import com.example.ms.tweet.dto.request.SaveTagDto;
import com.example.ms.tweet.dto.response.TagResponse;
import com.example.ms.tweet.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.ms.tweet.mapper.TagMapper.buildTagEntity;

@Service
@RequiredArgsConstructor

public class TagService {
    private final TagRepository tagRepository;

    public List<TagResponse> getTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagMapper::buildTagResponse)
                .collect(Collectors.toList());
    }

    public void saveTag(SaveTagDto request) {
        var tag = buildTagEntity(request);
        tagRepository.save(tag);
    }

    public List<TagEntity> getTagsbyIds(Set<Long> tagIds) {
        return tagRepository.findAllById(tagIds);
    }

}
