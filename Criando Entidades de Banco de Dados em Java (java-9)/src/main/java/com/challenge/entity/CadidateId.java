package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class CadidateId implements Serializable {

    @ManyToOne
    private user user;

    @ManyToOne
    private company company;

    @ManyToOne
    private acceleration acceleration;


}
