package com.example.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class UserAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Заполнение поля логин обязательно")
    private String login;
    @NotNull(message = "Заполнение поля пароль обязательно")
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updated_at;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Users users;

    public UserAuth(UserAuth userAuth) {
        this.id = userAuth.id;
        this.login = userAuth.login;
        this.password = userAuth.password;
        this.created_at = userAuth.created_at;
        this.updated_at = userAuth.updated_at;
        this.users = userAuth.users;
    }
}
