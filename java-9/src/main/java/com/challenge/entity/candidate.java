package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@EntityListeners(AuditingEntityListener.class)

public class candidate {

    @EmbeddedId
    private CadidateId id;

    @Column
    @NotNull
    private int status;

    @CreatedDate
    private LocalDate created_at;

}