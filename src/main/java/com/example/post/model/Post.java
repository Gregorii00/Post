package com.example.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Post {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Заполнение поля запись обязательно")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updated_at;
    private String view;
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @JsonIgnoreProperties("postList")
    private Users users;

    public Post(Post post) {
        this.id = post.id;
        this.description = post.description;
        this.created_at = post.created_at;
        this.updated_at = post.updated_at;
        this.view = post.view;
        this.users = post.users;
    }
}
