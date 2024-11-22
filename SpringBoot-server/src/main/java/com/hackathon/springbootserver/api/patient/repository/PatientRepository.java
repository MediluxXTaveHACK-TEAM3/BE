package com.hackathon.springbootserver.api.patient.repository;

import com.hackathon.springbootserver.api.patient.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    // 이름으로 멤버를 검색
    Optional<PatientEntity> findById(Long id);

}