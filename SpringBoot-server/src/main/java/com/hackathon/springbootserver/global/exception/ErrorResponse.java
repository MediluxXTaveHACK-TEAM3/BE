package com.hackathon.springbootserver.global.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private int code;
    private String message;
}
