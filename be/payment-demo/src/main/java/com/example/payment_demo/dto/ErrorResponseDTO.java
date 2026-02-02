package com.example.payment_demo.dto;

import java.util.List;

public record ErrorResponseDTO(
        int status,
        String message,
        long timestamp,
        List<String> errors
) {
}
