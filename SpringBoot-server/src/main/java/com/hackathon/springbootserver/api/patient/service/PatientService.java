package com.hackathon.springbootserver.api.patient.service;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import com.hackathon.springbootserver.api.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public PatientEntity getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
    }


    // TODO : Id로 찾기 for join


}

