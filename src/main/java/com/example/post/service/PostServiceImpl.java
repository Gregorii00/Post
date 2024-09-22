package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Override
    public Post save(Post post) {
        Post post1 = new Post(post);
        post1.setView("True");
        return postRepo.save(post1);
    }
    @Override
    public List<Post> findPostList() {
        return postRepo.findAll();
    }
    @Override
    public Post findById(Long id) {
        Post post = postRepo.findById(id).get();
        return post;
    }
    @Override
    public Map<String, Object> deleteById(Long id) {
        Map<String, Object> respPost = new LinkedHashMap<String, Object>();
        postRepo.deleteById(id);
        respPost.put("status", 1);
        respPost.put("data", "Record is deleted successfully!");
        return respPost;
    }
    @Override
    public ResponseEntity updatePost(Post post, Long users_id) {
        Map<String, Object> respPost = new LinkedHashMap<String, Object>();
        int record  = postRepo.updatePost(post.getDescription(), LocalDateTime.now(), users_id);
        respPost.put("status", record);
        respPost.put("data", record+" record is updated.");
        if (record!=0) {
            return new ResponseEntity<>(respPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(respPost, HttpStatus.NOT_FOUND);
        }
    }
}
