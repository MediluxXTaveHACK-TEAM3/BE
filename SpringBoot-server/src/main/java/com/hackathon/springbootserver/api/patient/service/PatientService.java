package com.hackathon.springbootserver.api.patient.service;

import com.hackathon.springbootserver.api.diseases.domain.Disease;
import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import com.hackathon.springbootserver.api.patient.domain.PatientMapper;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientRequestDto;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientResponseDto;
import com.hackathon.springbootserver.api.patient.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Slf4j
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public PatientResponseDto createPatient(
            PatientRequestDto requestDto
    ) {
        PatientEntity savedPatient = patientRepository.save(
                PatientMapper.toEntity(requestDto)
        );

        return PatientMapper.toDto(savedPatient);
    }

    @Transactional(readOnly = true)
    public PatientEntity getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
    }

}

