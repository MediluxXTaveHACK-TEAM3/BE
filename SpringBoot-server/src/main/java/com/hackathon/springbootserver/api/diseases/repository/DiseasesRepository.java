package com.hackathon.springbootserver.api.diseases.repository;

import com.hackathon.springbootserver.api.diseases.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseasesRepository extends JpaRepository<Disease, Long> {

    Disease findByName(String diseasesName);
}
