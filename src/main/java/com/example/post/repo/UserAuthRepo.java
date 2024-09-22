package com.example.post.repo;

import com.example.post.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@RepositoryRestResource
public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
    @Transactional

    @Modifying

    @Query("update UserAuth set login=?1, password=?2, updated_at=?3 where id=?4")

    int updateUserAuth(String login, String password, LocalDateTime updated_at, Long id);
}
