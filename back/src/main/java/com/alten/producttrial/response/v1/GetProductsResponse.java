package com.alten.producttrial.response.v1;

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
