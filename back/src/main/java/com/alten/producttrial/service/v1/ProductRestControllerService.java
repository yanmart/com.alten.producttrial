package com.alten.producttrial.service.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.alten.producttrial.entity.Product;
import com.alten.producttrial.service.ProductPatcherService;
import com.alten.producttrial.service.ProductRepositoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRestControllerService 
{
	private ProductPatcherService productPatcherService; 
	private ProductRepositoryService productRepositoryService;
	
	public void createNewProduct(Product product) 
	{
		productRepositoryService.save(product);
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

	public void patchProduct(int id,  Product product) throws NotFoundException
	{
		Optional<Product> productOptional = getProduct(id);
		if ( productOptional.isEmpty() )
		{
			 throw new NotFoundException();
		}
		
		Product productToUpdate = productOptional.get();
		productPatcherService.patchProduct(productToUpdate, product);
		productRepositoryService.save(productToUpdate);
	}

	
}
