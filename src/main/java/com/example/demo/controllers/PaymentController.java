package com.example.demo.controllers;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentRequest;
import com.example.demo.service.PaymentNotFoundException;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody PaymentRequest amount) {
        return paymentService.createPayment(amount);
    }

    @PostMapping("/{paymentId}/confirm")
    public Payment confirmPayment(@PathVariable("paymentId") int paymentId) throws PaymentNotFoundException {
        return paymentService.confirmPayment(paymentId);
    }

    @GetMapping("/{paymentId}")
    public Payment.PaymentStatus getPaymentStatus(@PathVariable("paymentId") int paymentId) throws PaymentNotFoundException {
        return paymentService.getPaymentStatus(paymentId).getStatus();
    }

    @PostMapping("/{paymentId}/cancel")
    public Payment cancelPayment(@PathVariable("paymentId") int paymentId) throws PaymentNotFoundException {
        return paymentService.cancelPayment(paymentId);
    }

}
