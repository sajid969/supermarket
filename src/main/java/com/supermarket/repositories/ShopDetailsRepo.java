package com.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.models.ShopDetails;
@Repository
public interface ShopDetailsRepo extends JpaRepository<ShopDetails, Integer> {
	
	ShopDetails findByEmail(String email);

}
