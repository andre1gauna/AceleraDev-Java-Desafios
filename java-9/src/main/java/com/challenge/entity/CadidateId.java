package com.challenge.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;


@Embeddable
@EntityListeners(AuditingEntityListener.class)

public class CadidateId implements Serializable {

    @ManyToOne
    private user user;

    @ManyToOne
    private company company;

    @ManyToOne
    private acceleration acceleration;


}
