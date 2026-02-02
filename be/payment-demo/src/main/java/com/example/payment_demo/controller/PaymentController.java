package com.example.payment_demo.controller;

import com.example.payment_demo.dto.PaymentRequestDTO;
import com.example.payment_demo.dto.PaymentResponseDTO;
import com.example.payment_demo.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> createPayment(@Valid @RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponseDTO paymentResponse = paymentService.processPayment(paymentRequestDTO);

        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }
}
