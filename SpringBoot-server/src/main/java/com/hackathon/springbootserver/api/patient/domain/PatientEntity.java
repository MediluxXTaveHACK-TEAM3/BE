package com.hackathon.springbootserver.api.patient.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId; // 멤버 ID

    private String name; // 이름

    private String gender; // 성별

    private int age; // 나이

    private String diseases; // 기저질환

    private String visitedHos; // 다니던 병원

    private Long residentNo; // 주민등록번호

    private String address; // 주소
}
