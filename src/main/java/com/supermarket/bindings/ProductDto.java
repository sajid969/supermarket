package com.supermarket.bindings;

import java.util.List;

import com.supermarket.models.ProductEntity;
import com.supermarket.models.ShopDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDto {
	
	ShopDetails shopDetails;
	
	List<ProductEntity> productEntity;

}
