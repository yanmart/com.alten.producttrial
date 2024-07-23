package com.alten.producttrial.service.v1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alten.producttrial.model.Product;
import com.alten.producttrial.service.ProductPatcherService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductRestControllerService 
{
	private ProductPatcherService productPatcherService; 
	private List<Product> productList;
	
	public void createNewProduct(Product product) 
	{
		productList.add(product);
	}

	public List<Product> getProducts() 
	{
		return productList;
	}
	
	public Product getProduct(int id)
	{
		return productList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
	}

	public void removeProduct(int id) 
	{
		Product product = getProduct(id);
		
		productList.remove(product);
	}

	public void patchProduct(int id,  Product product)
	{
		Product productToUpdate = getProduct(id);
		productPatcherService.patchProduct(productToUpdate, product);
	}

	
}
