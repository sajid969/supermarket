package com.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.models.ProductDescription;

public interface ProductDescriptionRepo extends JpaRepository<ProductDescription, Integer> {

}
