package com.example.post.service;

import com.example.post.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsersService {
    Users save(Users users);

    List<Users> findUserList();

    Users findById(Long id);

    Map<String, Object> deleteById(Long id);

    ResponseEntity updateUsers(Users user, Long id);
}
