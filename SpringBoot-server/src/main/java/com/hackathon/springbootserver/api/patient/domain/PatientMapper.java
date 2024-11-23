package com.hackathon.springbootserver.api.patient.domain;

import com.hackathon.springbootserver.api.patient.domain.dto.PatientRequestDto;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientResponseDto;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PatientMapper {
    // 예약 DTO -> Entity
    public static PatientEntity toEntity(PatientRequestDto patientRequestDto) {

        return PatientEntity.builder()
                        .name(patientRequestDto.getName())
                        .gender(patientRequestDto.getGender())
                        .age(patientRequestDto.getAge())
                        .diseaseName(patientRequestDto.getDiseaseName())
                        .residentNo(patientRequestDto.getResidentNo())
                        .address(patientRequestDto.getAddress())
                        .build();
    }

//    // 예약 Entity -> DTO
    public static PatientResponseDto toDto(PatientEntity patient) {
        return PatientResponseDto.builder()
                        .name(patient.getName())
                        .gender(patient.getGender())
                        .age(patient.getAge())
                        .diseasesName(patient.getDiseaseName())
                        .residentNo(patient.getResidentNo())
                        .address(patient.getAddress())
                        .build();
    }
}
