package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Max(100)
    private String full_name;

    @NotNull
    @Max(100)
    private String email;

    @NotNull
    @Max(50)
    private String nickname;

    @NotNull
    @Max(255)
    private String password;

    @CreatedDate
    private Timestamp created_at;

    @OneToMany
    private List<candidate> candidate;

    @OneToMany
    private List<submission> submission;

}
