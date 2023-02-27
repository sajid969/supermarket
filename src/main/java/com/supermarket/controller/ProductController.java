package com.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.bindings.ProductById;
import com.supermarket.bindings.ProductDto;
import com.supermarket.bindings.ProductList;
import com.supermarket.models.ProductEntity;
import com.supermarket.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/shopCode/{shopCode}/products")
	public ResponseEntity<ProductDto> createProducts(@RequestBody ProductDto productDto, @PathVariable Integer shopCode){
		ProductDto saveProduct = productService.saveProduct(productDto, shopCode);
		return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity){
		ProductEntity createProduct = productService.createProduct(productEntity);
		return new ResponseEntity<ProductEntity>(createProduct, HttpStatus.CREATED);
	}
	@GetMapping("/products")
	public ResponseEntity<List<ProductList>> getProducts(){
		List<ProductList> products = productService.getProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/productId/{productId}/product")
	public ResponseEntity<ProductById> getProductsById(@PathVariable Integer productId){
		ProductById productById = productService.getProductById(productId);
		return new ResponseEntity<>(productById, HttpStatus.OK);
	}
	@GetMapping("/shopCode/{shopCode}/product/{productId}/activeSW")
	public ResponseEntity<ProductEntity> activeSW(@PathVariable Integer shopCode, @PathVariable Integer productId){
		ProductEntity activeSW = productService.activeSW(shopCode, productId);
		return new ResponseEntity<>(activeSW, HttpStatus.OK);
	}

}
