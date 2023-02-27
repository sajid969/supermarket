package com.supermarket.serviceImpls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.bindings.ShopDto;
import com.supermarket.models.AddressDetails;
import com.supermarket.models.ProductEntity;
import com.supermarket.models.ShopDetails;
import com.supermarket.repositories.AddressDetailsRepo;
import com.supermarket.repositories.ProductRepo;
import com.supermarket.repositories.ShopDetailsRepo;
import com.supermarket.services.ShopDetailsServices;

@Service
public class ShopDetailsServiceImpl implements ShopDetailsServices {

	@Autowired
	ShopDetailsRepo shopRepo;

	@Autowired
	AddressDetailsRepo addRepo;

	@Autowired
	ProductRepo productRepo;

	@Override
	public List<ShopDetails> getShopDetails() {
		List<ShopDetails> findAll = shopRepo.findAll();
		return findAll;
	}

	@Override
	public boolean createShopDetails(ShopDto shopDto) {
		ShopDetails findbyEmail = shopRepo.findByEmail(shopDto.getEmail());
		if (findbyEmail == null) {
			ShopDetails entity = new ShopDetails();
			BeanUtils.copyProperties(shopDto, entity);
			AddressDetails addressDetails = entity.getAddressDetails();
			addRepo.save(addressDetails);
			entity.setActiveSW("Active");
			ShopDetails save = shopRepo.save(entity);
			return save.getShopCode() != null;
		}
		return false;
	}

	@Override
	public ShopDetails activeSW(Integer shopCode) {
		Optional<ShopDetails> findById = shopRepo.findById(shopCode);

		List<ProductEntity> findByshopDetails = productRepo.findByshopDetails(shopCode);
		if (findById.isPresent()) {
			String activeSW = findById.get().getActiveSW();
			ShopDetails shopDetails = findById.get();
			if (activeSW.equalsIgnoreCase("Active")) {
				
				shopDetails.setActiveSW("InActive");
				shopRepo.save(shopDetails);
				for (ProductEntity entity : findByshopDetails) {
					
					if(entity.getActiveSW().equalsIgnoreCase("Active")) {
						entity.setActiveSW("InActive");
						productRepo.save(entity);
					}
					
					
				}
				return shopDetails;

			}else {
				shopDetails.setActiveSW("Active");
				shopRepo.save(shopDetails);
				for (ProductEntity entity : findByshopDetails) {
					if(entity.getActiveSW().equalsIgnoreCase("InActive")) {
						entity.setActiveSW("Active");
						productRepo.save(entity);
					}
					
				}
				
			}
			return shopDetails;
		}
		return null;
		
	}

	@Override
	public String deleteshop(Integer shopCode) {
		List<ProductEntity> findByshopDetails = productRepo.findByshopDetails(shopCode);
		for(ProductEntity entity : findByshopDetails) {
			entity.setActiveSW("Deleted");
			productRepo.save(entity);
		}
		Optional<ShopDetails> findById = shopRepo.findById(shopCode);
		if(findById.isPresent()) {
			shopRepo.deleteById(shopCode);
			String message = "Deleted Successfully";
			return message;
		}
		
		
		return null;
	}

}
