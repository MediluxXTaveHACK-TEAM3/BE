package com.hackathon.springbootserver.dto;

import com.hackathon.springbootserver.domain.PatientEntity;

public class PatientResponseDto {
    private Long id;
    private String name;

    public PatientResponseDto(PatientEntity patient) {
        this.id = patient.getPatientId();
        this.name = patient.getName();
    }

    // Getters
}

