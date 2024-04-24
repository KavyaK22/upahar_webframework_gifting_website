package com.example.cc1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1.model.Payment;
import com.example.cc1.model.Products;
import com.example.cc1.service.PaymentService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }

   @PostMapping("/payment")
    public String postMethodName(@RequestBody Payment payment) {
        paymentService.saveUser(payment);
        return "saved the details successfully ";
       
    }

   @GetMapping("/pay/{id}")
    public Payment getMethodName(@PathVariable("id") int a) {
        return paymentService.getUser(a);
    }

    @GetMapping("/paylist")
    public List<Payment> getList() {
        return paymentService.getallList();
    }

    @GetMapping("/decline/{s}")
    public List<Payment> getMethodName(@PathVariable String s) {
        return paymentService.getdeclineddata(s);
    }
    
}
