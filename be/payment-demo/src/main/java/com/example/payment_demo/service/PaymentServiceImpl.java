package com.example.payment_demo.service;

import com.example.payment_demo.dto.PaymentRequestDTO;
import com.example.payment_demo.dto.PaymentResponseDTO;
import com.example.payment_demo.entity.PaymentTransaction;
import com.example.payment_demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO){
        // check if there are duplicates
        if (paymentRepository.existsByIdempotencyKey(paymentRequestDTO.idempotencyKey())){
            throw  new RuntimeException("Duplicate transaction: " + paymentRequestDTO.idempotencyKey());
        }

        // create entity instance and insert data for saving
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setIdempotencyKey(paymentRequestDTO.idempotencyKey());
        paymentTransaction.setAmount(paymentRequestDTO.amount());
        paymentTransaction.setStatus("SUCCESS");

        PaymentTransaction savedTransaction = paymentRepository.save(paymentTransaction);

        return new PaymentResponseDTO(
                savedTransaction.getId(),
                savedTransaction.getIdempotencyKey(),
                savedTransaction.getAmount(),
                savedTransaction.getStatus()
        );
    }
}
