package com.lld.ticketbooking.model;

public class Payment {

    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private PaymentMethod method;

    public Payment(String paymentId, double amount, PaymentMethod method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        // keep it simple
        this.status = PaymentStatus.SUCCESS;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}