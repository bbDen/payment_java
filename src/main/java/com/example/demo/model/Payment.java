package com.example.demo.model;

import jakarta.persistence.*;



@Entity
public class Payment {

    public enum PaymentStatus {

        CREATED("Создан"),
        CONFIRMED("Подтвержден"),
        CANCELED("Отменен");

        private final String description;

        PaymentStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    private PaymentStatus status;

    public Payment() {
    }

    public Payment(double amount, PaymentStatus status) {
        this.amount = amount;
        this.status = PaymentStatus.CREATED;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
