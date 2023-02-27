package com.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.models.SubCategoryEntity;

public interface SubCategoryRepo extends JpaRepository<SubCategoryEntity, Integer> {

}
