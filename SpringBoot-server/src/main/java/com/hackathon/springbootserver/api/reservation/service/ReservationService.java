package com.hackathon.springbootserver.api.reservation.service;

import com.hackathon.springbootserver.api.diseases.repository.DiseasesRepository;
import com.hackathon.springbootserver.api.patient.repository.PatientRepository;
import com.hackathon.springbootserver.api.reservation.domain.Reservation;
import com.hackathon.springbootserver.api.reservation.domain.ReservationMapper;
import com.hackathon.springbootserver.api.reservation.domain.ReservationResponseDto;
import com.hackathon.springbootserver.api.reservation.repository.ReservationRepository;
import com.hackathon.springbootserver.global.exception.impl.AlreadyExistUserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DiseasesRepository diseasesRepository;

    // 사용자가 예약하기
    public ReservationResponseDto register(
            Long patientId,
            String hospName
    ) {
        // 사용자 찾기
        if (!patientRepository.findById(patientId).isPresent()) {
            throw new AlreadyExistUserException();
        }
        Reservation savedReservation = Reservation.builder()
                .patient(patientRepository.findById(patientId)
                        .orElseThrow(() -> new IllegalArgumentException()))
                .resDate(LocalDateTime.now())
                .hosName(hospName)
                .build();
        reservationRepository.save(savedReservation);

        return ReservationMapper.toReservationDto(savedReservation);
    }

    // 자동으로 다음 예약 잡기
    public ReservationResponseDto autoReservation(Long id) {
        return null;
    }
}
