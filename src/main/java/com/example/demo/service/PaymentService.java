package com.example.demo.service;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentRequest;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment(paymentRequest.getAmount(), Payment.PaymentStatus.CREATED);
        return paymentRepository.save(payment);
    }

    public Payment confirmPayment(int paymentId) throws PaymentNotFoundException {
        Payment payment = findPaymentById(paymentId);
        payment.setStatus(Payment.PaymentStatus.CONFIRMED);
        return paymentRepository.save(payment);
    }

    public Payment getPaymentStatus(int paymentId) throws PaymentNotFoundException {
        return findPaymentById(paymentId);
    }

    public Payment cancelPayment(int paymentId) throws PaymentNotFoundException {
        Payment payment = findPaymentById(paymentId);
        payment.setStatus(Payment.PaymentStatus.CANCELED);
        return paymentRepository.save(payment);
    }

    private Payment findPaymentById(int paymentId) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
        }
        return payment;
    }
}
