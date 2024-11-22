package com.hackathon.springbootserver.api.reservation.repository;

import com.hackathon.springbootserver.api.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
