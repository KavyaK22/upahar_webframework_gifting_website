package com.example.cc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cc1.model.Payment;

import com.example.cc1.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment saveUser(Payment payment)
    {
        return paymentRepository.save(payment);
    }

    public Payment getUser(int id)
    {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getallList()
    {
        return paymentRepository.findAll();
    }

    public List<Payment> getdeclineddata(String s)
    {
       return paymentRepository.findByStatusContains(s);
    }
}
