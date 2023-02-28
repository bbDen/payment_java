package com.example.demo.service;

public class PaymentNotFoundException extends Exception{
    public PaymentNotFoundException(String statement){
        super (statement);
    }
}
