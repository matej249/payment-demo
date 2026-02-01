package com.example.payment_demo.dto;

import java.math.BigDecimal;

public record PaymentResponseDTO(
        Long id,
        String idempotencyKey,
        BigDecimal amount,
        String status
) {
}
