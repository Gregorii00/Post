package com.example.post.controllers;

import com.example.post.model.Post;
import com.example.post.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(description = "Методы работы с постами",
        name = "Post")
@RestController
@RequestMapping("/users/authorisation")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/{users_id}/post")
    public ResponseEntity<?> save(@Valid @RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
    @GetMapping("/{users_id}/post")
    public ResponseEntity <List<Post>> getAllPost() {
        return ResponseEntity.ok(postService.findPostList());
    }
    @GetMapping("/{users_id}/post/{post_id}")
    public ResponseEntity <?> getPost(@PathVariable("post_id") Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }
    @DeleteMapping("/{users_id}/post/{post_id}")
    public ResponseEntity<?> deleteById(@PathVariable("post_id") Long id) {
        return new ResponseEntity<>(postService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{users_id}/post/{post_id}")
    public ResponseEntity<?> updatePost(@Valid @RequestBody Post post, @PathVariable("post_id") Long id) {
        ResponseEntity respPost =postService.updatePost(post, id);
        return new ResponseEntity<>(respPost , respPost.getStatusCode());
    }
}
