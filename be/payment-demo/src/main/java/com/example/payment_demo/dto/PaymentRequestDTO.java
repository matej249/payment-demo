package com.example.payment_demo.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        @NotBlank(message = "Idempotency key is required")
        String idempotencyKey,
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        BigDecimal amount
) {
}
