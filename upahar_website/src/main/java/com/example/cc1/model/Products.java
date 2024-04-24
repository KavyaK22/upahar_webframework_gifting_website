package com.example.cc1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
   @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int productQuantity;
    private int productPrice;

//  @OneToOne
//  @JsonBackReference
//  private User user;

@ManyToOne
@JsonBackReference
private User user;

}
