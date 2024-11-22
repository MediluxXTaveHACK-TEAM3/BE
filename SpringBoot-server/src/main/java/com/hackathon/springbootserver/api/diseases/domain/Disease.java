package com.hackathon.springbootserver.api.diseases.domain;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Disease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "patient_id") // Foreign Key
    private PatientEntity patient;

}
