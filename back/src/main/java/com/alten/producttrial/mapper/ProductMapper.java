package com.alten.producttrial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alten.producttrial.entity.Product;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
componentModel = "spring")
public interface ProductMapper 
{
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget Product existingProduct,  Product incompleteProduct);

}
