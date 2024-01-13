package com.example.ms.tweet.controller;

import com.example.ms.tweet.dto.request.SaveTagDto;
import com.example.ms.tweet.dto.response.TagResponse;
import com.example.ms.tweet.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/tweet/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveTag(@RequestBody SaveTagDto dto) {
        tagService.saveTag(dto);
    }

    @GetMapping
    public List<TagResponse> getTags() {
        return tagService.getTags();
    }

}
