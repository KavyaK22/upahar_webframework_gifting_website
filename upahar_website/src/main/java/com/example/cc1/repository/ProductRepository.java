package com.example.cc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cc1.model.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products,Integer>
{
   Products findByProductNameEndsWith(String s);
}
