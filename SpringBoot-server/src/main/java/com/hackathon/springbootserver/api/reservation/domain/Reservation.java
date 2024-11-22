package com.hackathon.springbootserver.api.reservation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resId;

    private LocalDate resDate;

    private String status;

    private String hosName;
}
