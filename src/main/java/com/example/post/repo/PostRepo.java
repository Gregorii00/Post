package com.example.post.repo;

import com.example.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RepositoryRestResource
public interface PostRepo extends JpaRepository<Post, Long> {
    @Transactional

    @Modifying

    @Query("update Post set description=?1, updated_at=?2 where id=?3")

    int updatePost(String description,LocalDateTime updated_at, Long id);
}
