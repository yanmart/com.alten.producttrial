package com.alten.producttrial.configuration;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.alten.producttrial.model.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Configuration
@EnableWebMvc
public class ProductTrialConfiguration 
{
	@Value("classpath:products.json")
	private Resource productsFile;
	
	@Bean
	List<Product> productList() throws JsonSyntaxException, IOException
	{
		JsonObject jsonObject = (JsonObject)JsonParser.parseString(productsFile.getContentAsString(StandardCharsets.UTF_8));
		
		JsonArray jsonArray = (JsonArray)jsonObject.get("data");
		
		Type listType = new TypeToken<List<Product>>() {}.getType();
		
		return new Gson().fromJson(jsonArray,listType);
	}

}
