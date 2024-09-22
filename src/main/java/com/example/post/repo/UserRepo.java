package com.example.post.repo;

import com.example.post.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<Users, Long> {
    @Transactional

    @Modifying

    @Query("update Users set surname=?1, name=?2, patronymic=?3, gender=?4, birthday=?5, updated_at=?6 where id=?7")

    int updateUsers(String surname, String name, String patronymic, String gender, Date birthday, LocalDateTime updated_at, Long id);
}
