package com.supermarket.bindings;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductList {
	@Id
	public Integer productId;
	
	public String productName;
	
	public float actualPrice;
	
	public Integer discount;
	
	public float finalPrice;
}
