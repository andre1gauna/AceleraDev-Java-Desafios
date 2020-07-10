package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotNull
    @Size(max = 100)
    private String fullname;

    @NotNull
    @Column(name = "email")
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate created_at;

    @OneToMany
    private List<candidate> candidate;

    @OneToMany
    private List<submission> submission;

}
