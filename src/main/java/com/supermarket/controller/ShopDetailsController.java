package com.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.bindings.ShopDto;
import com.supermarket.models.ShopDetails;
import com.supermarket.services.ShopDetailsServices;

@RestController
public class ShopDetailsController {
	
	@Autowired
	ShopDetailsServices shopService;
	
	@PostMapping("/shop")
	public ResponseEntity<String> createShop(@RequestBody ShopDto shopDto){
		boolean createShopDetails = shopService.createShopDetails(shopDto);
		if(createShopDetails) {
			return new ResponseEntity<>("Account Created Succesffully", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Email Already Exists", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/shop")
	public ResponseEntity<List<ShopDetails>> getShopDetails(){
		List<ShopDetails> shopDetails = shopService.getShopDetails();
		return new ResponseEntity<List<ShopDetails>>(shopDetails, HttpStatus.OK);
	}
	
	@GetMapping("/shopcode/{shopCode}/activeSW")
	public ResponseEntity<ShopDetails> activeSW(@PathVariable Integer shopCode){
		ShopDetails activeSW = shopService.activeSW(shopCode);
		return new ResponseEntity<ShopDetails>(activeSW , HttpStatus.OK);
	}
	
	@DeleteMapping("/shopcode/{shopCode}/deleteshop")
	public ResponseEntity<String> deleteShop(@PathVariable Integer shopCode){
		String deleteshop = shopService.deleteshop(shopCode);
		return new ResponseEntity<String>(deleteshop, HttpStatus.OK);
	}

}
