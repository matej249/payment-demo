package com.example.payment_demo.service;

import com.example.payment_demo.dto.PaymentRequestDTO;
import com.example.payment_demo.dto.PaymentResponseDTO;

public interface PaymentService {

    PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO);
}
