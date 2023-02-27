package com.supermarket.bindings;

import com.supermarket.models.ProductDescription;
import com.supermarket.models.ShopDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductById {
	
	public ProductList productList;
	
	public ProductDescription prodDesc;
	
	public ShopDetails shopDetails;

}
