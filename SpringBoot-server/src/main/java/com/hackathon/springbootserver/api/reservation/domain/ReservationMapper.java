package com.hackathon.springbootserver.api.reservation.domain;

public class ReservationMapper {
    // 예약 DTO -> Entity
    public static Reservation toReservationEntity(ReservationRequestDto bankRequestDto) {
        return Reservation.builder()

                .build();
    }

    // 예약 Entity -> DTO
    public static ReservationResponseDto toReservationDto(Reservation reservation) {
        return ReservationResponseDto.builder()
                .patientName(reservation.getPatient().getName())
                .resDate(reservation.getResDate())
                .hosName(reservation.getHosName())
                .diseaseName(reservation.getDisease().getName())
                .build();
    }
}
