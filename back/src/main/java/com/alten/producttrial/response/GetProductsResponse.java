package com.alten.producttrial.response;

import java.util.List;

import com.alten.producttrial.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetProductsResponse
{
	private List<Product> data;
}
