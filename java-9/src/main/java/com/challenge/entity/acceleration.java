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

public class acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Max(100)
    private String name;

    @NotNull
    @Max(50)
    private String slug;

    @NotNull
    private int challenge_id;

    @CreatedDate
    private Timestamp created_at;

    @ManyToOne
    private challenge challenge;

    @OneToMany
    private List<candidate> candidate;

}
