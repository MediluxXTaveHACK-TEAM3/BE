package com.hackathon.springbootserver.api.visit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Visit {
    @Id @GeneratedValue
    private Long visitId;

    private int visitCount;
}
