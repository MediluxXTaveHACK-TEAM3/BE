package com.hackathon.springbootserver.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private int code;
    private String message;
}
