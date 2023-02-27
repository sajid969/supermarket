package com.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.models.AddressDetails;
@Repository
public interface AddressDetailsRepo extends JpaRepository<AddressDetails, Integer> {

}
