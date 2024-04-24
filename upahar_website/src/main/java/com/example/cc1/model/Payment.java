package com.example.cc1.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private String status;
    // private Date transactionDate = Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yy-MM-dd")));
   private Time transactionTime = Time.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    
}
