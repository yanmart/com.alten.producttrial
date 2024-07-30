package com.alten.producttrial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.alten.producttrial.entity.Product;
import com.alten.producttrial.mapper.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRestControllerService 
{
	private ProductRepositoryService productRepositoryService;
	private ProductMapper mapper;
	
	public Product createNewProduct(Product product) 
	{
		return productRepositoryService.save(product);
	}

	public List<Product> getProducts() 
	{
		return productRepositoryService.findAll();
	}
	
	public Optional<Product> getProduct(int id)
	{
		return productRepositoryService.findById(id);
	}

	public void removeProduct(int id) 
	{
		productRepositoryService.deleteById(id);
	}

	public Product patchProduct(int id,  Product product) throws NotFoundException
	{
		Optional<Product> productOptional = getProduct(id);
		if ( productOptional.isEmpty() )
		{
			 throw new NotFoundException();
		}
		
		Product productToUpdate = productOptional.get();
		
		mapper.update(productToUpdate, product);
		
		productRepositoryService.save(productToUpdate);
		
		return productToUpdate;
	}

	
}
