package com.hackathon.springbootserver.api.reservation.service;

import com.hackathon.springbootserver.api.patient.repository.PatientRepository;
import com.hackathon.springbootserver.api.reservation.domain.ReservationResponseDto;
import com.hackathon.springbootserver.api.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;

    // 사용자가 예약하기
    public ReservationResponseDto register(
            Long patientId,
            String diseasesName,
            LocalDate reservationDate,
            String hospName
    ) {
        
       return null;
    }

    // 자동으로 다음 예약 잡기
    public ReservationResponseDto autoReservation(Long id) {
        return null;
    }
}
