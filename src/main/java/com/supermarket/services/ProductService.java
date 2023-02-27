package com.supermarket.services;

import java.util.List;

import com.supermarket.bindings.ProductById;
import com.supermarket.bindings.ProductDto;
import com.supermarket.bindings.ProductList;
import com.supermarket.models.ProductEntity;

public interface ProductService {
	
	public ProductDto saveProduct(ProductDto productDto, Integer shopCode);
	
	public ProductEntity createProduct(ProductEntity productEntity);
	
	public List<ProductList> getProducts();
	
	public ProductById getProductById(Integer productId);
	
	public ProductEntity activeSW(Integer shopCode, Integer productId);

}
