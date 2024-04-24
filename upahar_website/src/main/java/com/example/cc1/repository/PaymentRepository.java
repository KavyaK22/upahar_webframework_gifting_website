package com.example.cc1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cc1.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{
   List<Payment> findByStatusContains(String s);
}
