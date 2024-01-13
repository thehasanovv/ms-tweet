package com.example.ms.tweet.controller;

import com.example.ms.tweet.model.request.SaveCommentDto;
import com.example.ms.tweet.model.request.SavePostDto;
import com.example.ms.tweet.model.response.PostResponse;
import com.example.ms.tweet.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/tweet/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    private PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    private void savePost(@RequestBody SavePostDto request) {
        postService.savePost(request);
    }

    @PostMapping("/{id}/comments")
    @ResponseStatus(NO_CONTENT)
    public void saveComment(@PathVariable Long id, @RequestBody SaveCommentDto request) {
        postService.saveComment(id, request);
    }


}
