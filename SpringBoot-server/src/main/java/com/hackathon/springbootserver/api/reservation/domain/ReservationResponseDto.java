package com.hackathon.springbootserver.api.reservation.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ReservationResponseDto {
    private LocalDateTime resDate;
    private String diseaseName;
    private String hosName;
    private String patientName;
}
