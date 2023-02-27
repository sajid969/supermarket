package com.supermarket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.models.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
	
	List<ProductEntity> findByactiveSW(String activeSw);
	
	List<ProductEntity> findByshopDetails(Integer shopDetails);

}
