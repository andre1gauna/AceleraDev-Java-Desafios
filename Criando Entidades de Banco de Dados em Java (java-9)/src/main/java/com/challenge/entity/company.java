package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Max(100)
    private String name;

    @NotNull
    @Max(50)
    private String slug;

    @CreatedDate
    private Timestamp created_at;

}
