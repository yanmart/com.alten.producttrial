package com.alten.producttrial.restcontroller;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.alten.producttrial.response.GetProductsResponse;
import com.alten.producttrial.service.ProductRestControllerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController 
{
	private ProductRestControllerService productRestControllerService;
	
	@PostMapping
	public Product createNewProduct( @RequestBody Product product )
	{
		return productRestControllerService.createNewProduct(product);
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
	public ResponseEntity<Product> updateProduct( @PathVariable int id , @RequestBody Product product )
	{
		ResponseEntity<Product> result;
		try 
		{
			Product productUpdated = productRestControllerService.patchProduct(id , product);
			result = new ResponseEntity<>(productUpdated,HttpStatus.OK);
		}
		catch (NotFoundException e) 
		{
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return result;
		 
	}
	
	

}
