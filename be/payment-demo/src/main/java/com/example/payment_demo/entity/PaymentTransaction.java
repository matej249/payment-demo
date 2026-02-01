package com.example.payment_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Idempotency key is required")
    @Column(name = "idempotency_key", unique = true, nullable = false)
    private String idempotencyKey;

    @Column(name = "amount", nullable = false)
    @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
    private BigDecimal amount;

    @Column(name = "status", nullable = false)
    @NotBlank(message = "Status can not be empty.")
    private String status;

    public PaymentTransaction() {
    }

    public PaymentTransaction(Long id, String idempotencyKey, BigDecimal amount, String status) {
        this.id = id;
        this.idempotencyKey = idempotencyKey;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "id=" + id +
                ", idempotencyKey='" + idempotencyKey + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
