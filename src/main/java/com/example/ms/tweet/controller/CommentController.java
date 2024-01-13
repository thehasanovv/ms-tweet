package com.example.ms.tweet.controller;

import com.example.ms.tweet.model.response.CommentResponse;
import com.example.ms.tweet.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequestMapping("v1/tweet")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PatchMapping("/comments/{id}/view-status")
    @ResponseStatus(NO_CONTENT)
    public void changeCommentViewStatus(@PathVariable Long id) {
        commentService.changeCommentViewStatus(id);
    }

    @PatchMapping("/comments/{id}/content")
    @ResponseStatus(NO_CONTENT)
    public void changeCommentContent(@PathVariable Long id, @RequestParam String value) {
        commentService.changeCommentContent(id, value);
    }

    @GetMapping("/posts/{postId}")
    public List<CommentResponse> getCommentsByPost(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }
}
