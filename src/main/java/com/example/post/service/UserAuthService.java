package com.example.post.service;

import com.example.post.model.UserAuth;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserAuthService {
    UserAuth save(UserAuth userAuth);

    List<UserAuth> findUserAuthList();

    UserAuth findById(Long id);

    Map<String, Object> deleteById(Long id);

    ResponseEntity updateUserAuth(UserAuth userAuth, Long id);
}
