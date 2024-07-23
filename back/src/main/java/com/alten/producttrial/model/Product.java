package com.alten.producttrial.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	@Generated
	private int id;
	private String code;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private InventoryStatus inventoryStatus;
	private Category category;
	private String image;
	private int rating;
}
