package com.example.payment_demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record PaymentRequestDTO(
        @NotBlank(message = "Idempotency key is required")
        String idempotencyKey,
        @Positive(message = "Amount must be more than zero.")
        Double amount
) {
}
