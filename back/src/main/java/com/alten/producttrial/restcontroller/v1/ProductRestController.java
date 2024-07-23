package com.alten.producttrial.restcontroller.v1;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.producttrial.entity.Product;
import com.alten.producttrial.response.v1.GetProductsResponse;
import com.alten.producttrial.service.v1.ProductRestControllerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController 
{
	private ProductRestControllerService productRestControllerService;
	
	@PostMapping
	public void createNewProduct( @RequestBody Product product )
	{
		productRestControllerService.createNewProduct(product);
	}
	
	@GetMapping
	public GetProductsResponse getProducts()
	{
		return new GetProductsResponse(productRestControllerService.getProducts());
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct( @PathVariable int id )
	{
		return productRestControllerService.getProduct(id);
	}
	
	@DeleteMapping("/{id}")
	public void removeProduct( @PathVariable int id )
	{
		productRestControllerService.removeProduct(id);
	}
	
	@PatchMapping(path="/{id}")
	public void updateProduct( @PathVariable int id , @RequestBody Product product ) throws NotFoundException
	{
		productRestControllerService.patchProduct(id , product);
	}
	
	

}
