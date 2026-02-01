package com.example.payment_demo.dto;

public record PaymentResponseDTO(
        Long id,
        String idempotencyKey,
        Double amount,
        String status
) {
}
