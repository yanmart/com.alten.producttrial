package com.alten.producttrial.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alten.producttrial.entity.Category;
import com.alten.producttrial.entity.InventoryStatus;
import com.alten.producttrial.entity.Product;

@Service
public class ProductPatcherService 
{
	public void patchProduct(Product existingProduct,  Product incompleteProduct)
	{
		if ( existingProduct != null )
		{
			patchProductCode(existingProduct, incompleteProduct.getCode());
			
			patchProductName(existingProduct, incompleteProduct.getName());
			
			patchProductDescription(existingProduct, incompleteProduct.getDescription());
			
			patchProductPrice(existingProduct, incompleteProduct.getPrice());
			
			patchProductQuantity(existingProduct, incompleteProduct.getQuantity());
			
			patchProductInventoryStatus(existingProduct, incompleteProduct.getInventoryStatus());
			
			patchProductCategory(existingProduct, incompleteProduct.getCategory());
			
			patchProductImage(existingProduct, incompleteProduct.getImage());
			
			patchProductRating(existingProduct, incompleteProduct.getRating());
		}
	}

	private void patchProductCode(Product existingProduct, String productCode) 
	{
		if (productCode != null &&  ! StringUtils.equals(productCode, existingProduct.getCode()))
		{
			existingProduct.setCode(productCode);
		}
		
	}

	private void patchProductName(Product existingProduct , String productName)
	{
		if (productName != null &&  ! StringUtils.equals(productName, existingProduct.getName()))
		{
			existingProduct.setName(productName);
		}
	}

	private void patchProductDescription(Product existingProduct , String productDescription)
	{
		if (productDescription != null &&  ! StringUtils.equals(productDescription, existingProduct.getDescription()))
		{
			existingProduct.setDescription(productDescription);
		}
	}

	private void patchProductPrice(Product existingProduct , int productPrice)
	{
		if (productPrice != 0 &&  productPrice != existingProduct.getPrice())
		{
			existingProduct.setPrice(productPrice);
		}
	}

	private void patchProductQuantity(Product existingProduct , int productQuantity)
	{
		if (productQuantity != 0 &&  productQuantity != existingProduct.getQuantity())
		{
			existingProduct.setQuantity(productQuantity);
		}
	}
	
	private void patchProductInventoryStatus(Product existingProduct, InventoryStatus productInventoryStatus) 
	{
		if (productInventoryStatus != null && ! productInventoryStatus.equals(existingProduct.getInventoryStatus()))
		{
			existingProduct.setInventoryStatus(productInventoryStatus);
		}
	}

	private void patchProductCategory(Product existingProduct, Category productCategory) 
	{
		if (productCategory != null && ! productCategory.equals(existingProduct.getCategory()))
		{
			existingProduct.setCategory(productCategory);
		}
	}

	private void patchProductImage(Product existingProduct, String productImage) 
	{
		if (productImage != null &&  ! StringUtils.equals(productImage, existingProduct.getImage()))
		{
			existingProduct.setImage(productImage);
		}
	}

	private void patchProductRating(Product existingProduct, int productRating) 
	{
		if (productRating != 0 &&  productRating != existingProduct.getRating())
		{
			existingProduct.setRating(productRating);
		}
	}

}
