package com.example.post.service;

import com.example.post.model.UserAuth;
import com.example.post.repo.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserAuthRepo userAuthRepo;

    @Override
    public UserAuth save(UserAuth userAuth) {
        UserAuth userAuth1 = new UserAuth(userAuth);
        return userAuthRepo.save(userAuth1);
    }

    @Override
    public List<UserAuth> findUserAuthList() {
        return userAuthRepo.findAll();
    }
    @Override
    public UserAuth findById(Long id) {
        UserAuth userAuth = userAuthRepo.findById(id).get();
        return userAuth;
    }
    @Override
    public Map<String, Object> deleteById(Long id) {
        Map<String, Object> respUserAuth = new LinkedHashMap<String, Object>();
        userAuthRepo.deleteById(id);
        respUserAuth.put("status", 1);
        respUserAuth.put("data", "Record is deleted successfully!");
        return respUserAuth;
    }

    @Override
    public ResponseEntity updateUserAuth(UserAuth userAuth, Long userAuth_id) {
        Map<String, Object> respUserAuth = new LinkedHashMap<String, Object>();
        int record  = userAuthRepo.updateUserAuth(userAuth.getLogin(), userAuth.getPassword(), LocalDateTime.now(), userAuth_id);
        respUserAuth.put("status", record);
        respUserAuth.put("data", record+" record is updated.");
        if (record!=0) {
            return new ResponseEntity<>(respUserAuth, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(respUserAuth, HttpStatus.NOT_FOUND);
        }
    }
}
