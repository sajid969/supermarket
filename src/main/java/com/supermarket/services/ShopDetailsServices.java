package com.supermarket.services;

import java.util.List;

import com.supermarket.bindings.ShopDto;
import com.supermarket.models.ShopDetails;

public interface ShopDetailsServices {
	
	boolean createShopDetails(ShopDto shopDto);
	
	List<ShopDetails> getShopDetails();
	
	ShopDetails activeSW(Integer shopCode);
	
	String deleteshop(Integer shopCode);

}
