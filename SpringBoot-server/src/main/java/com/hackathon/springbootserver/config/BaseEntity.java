package com.hackathon.springbootserver.config;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 활성화
@Getter
@Setter
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate // 생성일 자동 관리
    @Column(updatable = false) // 생성일은 수정되지 않도록 설정
    private LocalDate createdAt;

    @LastModifiedDate // 수정일 자동 관리
    private LocalDate updatedAt;
}