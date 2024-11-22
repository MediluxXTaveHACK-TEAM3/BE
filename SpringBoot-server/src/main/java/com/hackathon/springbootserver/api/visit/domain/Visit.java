package com.hackathon.springbootserver.api.visit.domain;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import jakarta.persistence.*;

@Entity
public class Visit {
    @Id @GeneratedValue
    private Long visitId;

    private int visitCount;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // Foreign Key: patient_id
    private PatientEntity patient;
}
