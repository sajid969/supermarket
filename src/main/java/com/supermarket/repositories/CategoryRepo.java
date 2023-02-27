package com.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.models.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

}
