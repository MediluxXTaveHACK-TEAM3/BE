package com.hackathon.springbootserver.api.patient.controller;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientRequestDto;
import com.hackathon.springbootserver.api.patient.domain.dto.PatientResponseDto;
import com.hackathon.springbootserver.api.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "환자 기록 관련 API")
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("patient/createPatient")
    @Operation(summary = "회원 등록하기")
    public ResponseEntity<PatientResponseDto> createPatient(
            @RequestBody PatientRequestDto patientRequestDto
    ) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDto));
    }


    @GetMapping("/{id}")
    @Operation(summary = "회원 읽어오기", description = "환자 정보 읽어오는 API 입니다.")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id) {
        PatientEntity patient = patientService.getPatientById(id);
        return ResponseEntity.ok(new PatientResponseDto(patient));
    }
}

