package com.hackathon.springbootserver.repository;

import com.hackathon.springbootserver.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    // 이름으로 멤버를 검색
    Optional<PatientEntity> findById(Long id);

}
