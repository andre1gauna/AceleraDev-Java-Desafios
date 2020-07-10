package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class submission {

    @EmbeddedId
    private UserChallenge userChallenge;

    @NotNull
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate created_at;

}