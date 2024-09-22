package com.example.post.service;

import com.example.post.model.Users;
import com.example.post.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Users save(Users users) {
        Users users1 = new Users(users);
        return userRepo.save(users1);
    }

    @Override
    public List<Users> findUserList() {
        return userRepo.findAll();
    }
    @Override
    public Users findById(Long id) {
        Users users = userRepo.findById(id).get();
        return users;
    }
    @Override
    public Map<String, Object> deleteById(Long id) {
        Map<String, Object> respUser = new LinkedHashMap<String, Object>();
        userRepo.deleteById(id);
        respUser.put("status", 1);
        respUser.put("data", "Record is deleted successfully!");
        return respUser;
    }

    @Override
    public ResponseEntity updateUsers(Users users, Long users_id) {
        Map<String, Object> respUser = new LinkedHashMap<String, Object>();
        int record  = userRepo.updateUsers(users.getSurname(), users.getName(), users.getPatronymic(),
                users.getGender(), users.getBirthday(), LocalDateTime.now(), users_id);
        respUser.put("status", record);
        respUser.put("data", record+" record is updated.");
        if (record!=0) {
            return new ResponseEntity<>(respUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(respUser, HttpStatus.NOT_FOUND);
        }
    }
}
