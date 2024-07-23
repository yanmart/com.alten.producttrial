package com.alten.producttrial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alten.producttrial.entity.Product;
import com.alten.producttrial.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRepositoryService 
{
	private ProductRepository productRepository;

	public List<Product> findAll() 
	{
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(int id)
	{
		return productRepository.findById(id);
	}
	
	public Product save(Product product) 
	{
		return productRepository.save(product);
	}
	
	public void deleteById(int id) 
	{
		productRepository.deleteById(id);
	}
}
