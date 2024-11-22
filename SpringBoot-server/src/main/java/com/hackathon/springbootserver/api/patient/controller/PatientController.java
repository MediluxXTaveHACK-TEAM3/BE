package com.hackathon.springbootserver.api.patient.controller;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientResponseDto;
import com.hackathon.springbootserver.api.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id) {
        PatientEntity patient = patientService.getPatientById(id);
        return ResponseEntity.ok(new PatientResponseDto(patient));
    }
}

