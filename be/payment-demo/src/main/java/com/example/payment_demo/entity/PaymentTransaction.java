package com.example.payment_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "payments")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idempotency_key", unique = true, nullable = false)
    private String idempotencyKey;

    @Column(name = "amount")
    @Positive(message = "Amount must be more than zero.")
    private Double amount;

    @Column(name = "status")
    @NotBlank(message = "Status can not be empty.")
    private String status;

    public PaymentTransaction() {
    }

    public PaymentTransaction(Long id, String idempotencyKey, Double amount, String status) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
