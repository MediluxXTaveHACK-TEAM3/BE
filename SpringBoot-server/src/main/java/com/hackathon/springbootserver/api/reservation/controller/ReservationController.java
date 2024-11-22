package com.hackathon.springbootserver.api.reservation.controller;

import com.hackathon.springbootserver.api.reservation.domain.ReservationRequestDto;
import com.hackathon.springbootserver.api.reservation.domain.ReservationResponseDto;
import com.hackathon.springbootserver.api.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    // 사용자가 예약하기 API
    @PostMapping("/createReservation")
    public ResponseEntity<ReservationResponseDto> register(
            @RequestParam Long patientId,
            @RequestParam String diseasesName,
            @RequestParam String hospName
    ) {
        ReservationResponseDto register = reservationService.register(patientId, diseasesName, hospName);
        return ResponseEntity.ok(register);
    }


    // 자동 예약 날짜 계산해 예약 등록 API
}
