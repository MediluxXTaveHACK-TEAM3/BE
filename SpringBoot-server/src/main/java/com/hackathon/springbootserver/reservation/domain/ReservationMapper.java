package com.hackathon.springbootserver.reservation.domain;

public class ReservationMapper {
    // 예약 DTO -> Entity
    public static Reservation toReservationEntity(ReservationRequestDto bankRequestDto) {
        return Reservation.builder()

                .build();
    }

    // 예약 Entity -> DTO
    public static ReservationResponseDto toReservationDto(Reservation reservation) {
        return ReservationResponseDto.builder()

                .build();
    }
}
