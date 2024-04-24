package com.example.cc1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cc1.model.Products;
import com.example.cc1.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

   @PostMapping("/product")
    public String postMethodName(@RequestBody Products products) {
        productService.saveUser(products);
        return "saved the details successfully ";
       
    }

   @GetMapping("/pro/{id}")
    public Products getMethodName(@PathVariable("id") int a) {
        return productService.getUser(a);
    }

    @GetMapping("/List")
    public List<Products> getList() {
        return productService.getallList();
    }
}
