package com.example.post.service;

import com.example.post.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PostService {
    Post save(Post post);
    Map<String, Object> deleteById(Long id);
    ResponseEntity updatePost(Post post, Long id);
    List<Post> findPostList();
    Post findById(Long id);
}
