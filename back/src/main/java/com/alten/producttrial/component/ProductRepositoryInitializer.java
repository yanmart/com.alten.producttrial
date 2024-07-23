package com.alten.producttrial.component;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.alten.producttrial.entity.Product;
import com.alten.producttrial.service.ProductRepositoryService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductRepositoryInitializer implements CommandLineRunner
{
	private ProductRepositoryService productRepositoryService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		Resource productsFile = new ClassPathResource("products.json");
		JsonObject jsonObject = (JsonObject)JsonParser.parseString(productsFile.getContentAsString(StandardCharsets.UTF_8));
		
		JsonArray jsonArray = (JsonArray)jsonObject.get("data");
		
		Type listType = new TypeToken<List<Product>>() {}.getType();
		
		List<Product> productList = new Gson().fromJson(jsonArray,listType);
		
		for(Product product : productList)
		{
			productRepositoryService.save(product);
		}
	}

}
