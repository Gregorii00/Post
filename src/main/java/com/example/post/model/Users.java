package com.example.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Заполнение поля 'фамилия' обязательно")
    private String surname;
    @NotNull(message = "Заполнение поля 'имя' обязательно")
    private String name;
    private String patronymic;
    private String gender;
    @Past(message = "Birthday date in the future")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updated_at;
    @OneToOne(mappedBy="users", cascade = CascadeType.ALL)
    private UserAuth userAuth;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("users")
    private List<Post> postList;

    public Users(Users users) {
        this.id = users.id;
        this.surname = users.surname;
        this.name = users.name;
        this.patronymic = users.patronymic;
        this.gender = users.gender;
        this.birthday = users.birthday;
        this.created_at = users.created_at;
        this.updated_at = users.updated_at;
        this.userAuth = users.userAuth;
    }

}
