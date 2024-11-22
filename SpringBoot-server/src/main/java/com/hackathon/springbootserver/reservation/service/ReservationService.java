package com.hackathon.springbootserver.reservation.service;

import com.hackathon.springbootserver.reservation.domain.Reservation;
import com.hackathon.springbootserver.reservation.domain.ReservationResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class ReservationService {

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
