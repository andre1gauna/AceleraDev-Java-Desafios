package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class candidate {
    @Id
    @EmbeddedId
    private CadidateId id;

    @Column
    @NotNull
    private int status;

    @CreatedDate
    private LocalDate created_at;

}