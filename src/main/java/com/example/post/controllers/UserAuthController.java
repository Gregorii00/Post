package com.example.post.controllers;

import com.example.post.model.UserAuth;
import com.example.post.service.UserAuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(description = "Методы работы с пользовательскими авторизациями",
        name = "UserAuth")
@RestController
@RequestMapping("/users/authorisation")
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;
    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody UserAuth userAuth) {
        return new ResponseEntity<>(userAuthService.save(userAuth), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity <List<UserAuth>> getAllUserAuth() {
        return ResponseEntity.ok(userAuthService.findUserAuthList());
    }
    @GetMapping("/{users_id}")
    public ResponseEntity <?> getUserAuth(@PathVariable("users_id") Long id) {
        return ResponseEntity.ok(userAuthService.findById(id));
    }
    @DeleteMapping("/{users_id}")
    public ResponseEntity<?> deleteById(@PathVariable("users_id") Long id) {
        return new ResponseEntity<>(userAuthService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{users_id}")
    public ResponseEntity<?> updateUserAuth(@Valid @RequestBody UserAuth userAuth, @PathVariable("users_id") Long id) {
        ResponseEntity respUserAuth =userAuthService.updateUserAuth(userAuth, id);
        return new ResponseEntity<>(respUserAuth , respUserAuth.getStatusCode());
    }
}
