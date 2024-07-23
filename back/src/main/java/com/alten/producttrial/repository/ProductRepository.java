package com.alten.producttrial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.producttrial.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{
}
