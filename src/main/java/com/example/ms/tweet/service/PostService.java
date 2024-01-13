package com.example.ms.tweet.service;

import com.example.ms.tweet.dao.entity.PostEntity;
import com.example.ms.tweet.dao.entity.TagEntity;
import com.example.ms.tweet.dao.repository.PostRepository;
import com.example.ms.tweet.dto.request.SaveCommentDto;
import com.example.ms.tweet.dto.request.SavePostDto;
import com.example.ms.tweet.dto.response.PostResponse;
import com.example.ms.tweet.exception.NotFoundException;
import com.example.ms.tweet.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.ms.tweet.constants.ExceptionConstants.POST_NOT_FOUND_CODE;
import static com.example.ms.tweet.constants.ExceptionConstants.POST_NOT_FOUND_MESSAGE;
import static com.example.ms.tweet.mapper.CommentMapper.buildCommentEntity;
import static com.example.ms.tweet.mapper.PostDetailMapper.buildPostDetailEntity;
import static com.example.ms.tweet.mapper.PostMapper.buildPostEntity;
import static com.example.ms.tweet.mapper.PostMapper.buildPostResponse;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final TagService tagService;

    public List<PostResponse> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::buildPostResponse)
                .collect(Collectors.toList());
    }

    public PostResponse getPost(Long id) {
        var post = fetchPostIfExist(id);
        return buildPostResponse(post);
    }

    public void savePost(SavePostDto request) {
        var post = buildPostEntity(request);
        var postDetail = buildPostDetailEntity(post, request.getCreatedBy());

        if (!request.getTagIds().isEmpty()) {
            List<TagEntity> tags = tagService.getTagsbyIds(request.getTagIds());
            post.setTags(tags);
        }

        post.setDetail(postDetail);
        postRepository.save(post);
    }

    public void saveComment(Long id, SaveCommentDto request) {
        var post = fetchPostIfExist(id);
        var comments = post.getComments();

        comments.add(buildCommentEntity(post, request.getContent()));
        postRepository.save(post);
    }

    private PostEntity fetchPostIfExist(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format(POST_NOT_FOUND_MESSAGE, id),
                        POST_NOT_FOUND_CODE));
    }
}
