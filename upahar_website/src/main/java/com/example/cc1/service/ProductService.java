package com.example.cc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cc1.model.Products;
import com.example.cc1.repository.ProductRepository;
@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public Products saveUser(Products products)
    {
        return productRepository.save(products);
    }

    public Products getUser(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public List<Products> getallList()
    {
        return productRepository.findAll();
    }
}
