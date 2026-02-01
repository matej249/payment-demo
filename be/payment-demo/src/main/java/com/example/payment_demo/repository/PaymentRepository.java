package com.example.payment_demo.repository;

import com.example.payment_demo.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentTransaction, Long> {

    // It will check the database for the unique idempotency key.
    boolean existsByIdempotencyKey(String idempotencyKey);
}
