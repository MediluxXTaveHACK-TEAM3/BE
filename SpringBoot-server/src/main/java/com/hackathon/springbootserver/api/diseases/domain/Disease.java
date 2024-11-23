package com.hackathon.springbootserver.api.diseases.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Disease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diseaseId;

    private String diseaseName;

    private String patientName;

}
