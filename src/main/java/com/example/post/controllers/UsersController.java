package com.example.post.controllers;

import com.example.post.model.Users;
import com.example.post.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(description = "Методы работы с пользователями",
        name = "Users")
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody Users users) {
        return new ResponseEntity<>(usersService.save(users), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity <List<Users>> getAllPatient() {
        return ResponseEntity.ok(usersService.findUserList());
    }
    @GetMapping("/{users_id}")
    public ResponseEntity <?> getPatient(@PathVariable("users_id") Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }
    @DeleteMapping("/{users_id}")
    public ResponseEntity<?> deleteById(@PathVariable("users_id") Long id) {
        return new ResponseEntity<>(usersService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{users_id}")
    public ResponseEntity<?> updatePatient(@Valid @RequestBody Users users, @PathVariable("users_id") Long id) {
        ResponseEntity respUsers =usersService.updateUsers(users, id);
        return new ResponseEntity<>(respUsers , respUsers.getStatusCode());
    }
}
