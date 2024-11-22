package com.hackathon.springbootserver.api.patient.domain.dto;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String diseases;
    private Long residentNo;
    private String address;

    public PatientResponseDto(PatientEntity patient) {
        this.id = patient.getPatientId();
        this.name = patient.getName();
    }

    // Getters
}

