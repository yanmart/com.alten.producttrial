package com.alten.producttrial.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Category 
{
	@JsonProperty("Accessories")
	ACCESSORIES,
	@JsonProperty("Clothing")
	CLOTHING,
	@JsonProperty("Electronics")
	ELECTRONICS,
	@JsonProperty("Fitness")
	FITNESS
}
