package com.hackathon.springbootserver.api.patient.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PatientRequestDto {
    private String name;
    private String gender;
    private int age;
    private String disease;
    private String vistedHos;
    private Long residentNo;
    private String address;
}
