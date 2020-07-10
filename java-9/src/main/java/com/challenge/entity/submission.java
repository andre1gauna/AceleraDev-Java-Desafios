package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class submission {

    @EmbeddedId
    private UserChallenge userChallenge;

    @NotNull
    private float score;

    @CreatedDate
    private Timestamp created_at;

}