package com.supermarket.serviceImpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.bindings.ProductById;
import com.supermarket.bindings.ProductDto;
import com.supermarket.bindings.ProductList;
import com.supermarket.models.ProductDescription;
import com.supermarket.models.ProductEntity;
import com.supermarket.models.ShopDetails;
import com.supermarket.models.SubCategoryEntity;
import com.supermarket.repositories.CategoryRepo;
import com.supermarket.repositories.ProductDescriptionRepo;
import com.supermarket.repositories.ProductRepo;
import com.supermarket.repositories.ShopDetailsRepo;
import com.supermarket.repositories.SubCategoryRepo;
import com.supermarket.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ProductDescriptionRepo desRepo;
	
	@Autowired
	ShopDetailsRepo shopRepo;
	
	@Autowired
	SubCategoryRepo subCatRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ShopDetailsRepo shopDetailsRepo;

	


	@Override
	public ProductDto saveProduct(ProductDto productDto, Integer shopCode) {
		Optional<ShopDetails> findById = shopRepo.findById(shopCode);
		if(findById.isPresent()) {
			List<ProductEntity> productEntity = productDto.getProductEntity();
			List<ProductEntity> product = new ArrayList<>();
			for(ProductEntity entity : productEntity) {
				ProductEntity prod = new ProductEntity();
				BeanUtils.copyProperties(entity, prod);			
				Optional<SubCategoryEntity> findSubCat = subCatRepo.findById(prod.getSubCategoryEntity());
				Integer categoryId = null;
				if(findSubCat.isPresent()) {
					categoryId = findSubCat.get().getCategoryId();
				}
				prod.setCategoryEntity(categoryId);
				prod.setShopDetails(shopCode);
				prod.setActiveSW("Active");
				ProductDescription prodDescrip = prod.getProductDescription();
				desRepo.save(prodDescrip);
				ProductEntity save = productRepo.save(prod);
				product.add(save);
				
				Optional<ShopDetails> findById2 = shopDetailsRepo.findById(shopCode);
				
				if(findById2.isPresent()) {
					ShopDetails shopDetails = findById2.get();
					productDto.setShopDetails(shopDetails);
				}
				
			}
			productDto.setProductEntity(product);
			return productDto;
		}
		return null;
	}
	

	@Override
	public ProductEntity createProduct(ProductEntity productEntity) {
		
		ProductEntity entity = new ProductEntity();
		BeanUtils.copyProperties(productEntity, entity);
		
		
		ProductDescription productDescription = entity.getProductDescription();
		desRepo.save(productDescription);

		
		ProductEntity save = productRepo.save(entity);
		
		return save;
	}
	
	


	@Override
	public List<ProductList> getProducts() {
		List<ProductList> list = new ArrayList<>();
		List<ProductEntity> findByactiveSW = productRepo.findByactiveSW("Active");
		for(ProductEntity entity : findByactiveSW) {
			ProductList productList = new ProductList();
			BeanUtils.copyProperties(entity, productList);
			list.add(productList);
		}
		return list;
	}

	@Override
	public ProductById getProductById(Integer productId) {
		
		Optional<ProductEntity> findById = productRepo.findById(productId);
		if(findById.isPresent()) {
			
			
			ProductEntity productEntity = findById.get();
			
			ProductById productById = new ProductById();
			
			ProductList prodEntity = new ProductList();
			BeanUtils.copyProperties(productEntity, prodEntity);
			productById.setProductList(prodEntity);
			
			ProductDescription productEntity1 = findById.get().getProductDescription();
			ProductDescription prodDes = new ProductDescription();
			BeanUtils.copyProperties(productEntity1, prodDes);
			productById.setProdDesc(prodDes);
			
			Integer shopDetails2 = findById.get().getShopDetails();
			Optional<ShopDetails> findById2 = shopDetailsRepo.findById(shopDetails2);
			if(findById2.isPresent()) {
				ShopDetails shopDetails3 = findById2.get();
				
				ShopDetails shopDe = new ShopDetails();
				BeanUtils.copyProperties(shopDetails3, shopDe);
				productById.setShopDetails(shopDe);
				return productById;
			}
		}
		
		return null;
	}


	@Override
	public ProductEntity activeSW(Integer shopCode, Integer productId) {
		Optional<ShopDetails> findById = shopDetailsRepo.findById(shopCode);
		if(findById.isPresent()) {
			List<ProductEntity> findByshopDetails = productRepo.findByshopDetails(findById.get().getShopCode());
			Optional<ProductEntity> findById2 = productRepo.findById(productId);
				String activeSW = findById2.get().getActiveSW();
				if(activeSW.equalsIgnoreCase("Active")) {
					ProductEntity productEntity = findById2.get();
					productEntity.setActiveSW("disabled");
					productRepo.save(productEntity);
					return productEntity;
				}else if(activeSW.equalsIgnoreCase("Deleted")) {
					ProductEntity productEntity = findById2.get();
					productEntity.setActiveSW("Deleted");
					productRepo.save(productEntity);
					return productEntity;
				
				}else {
					ProductEntity productEntity = findById2.get();
					productEntity.setActiveSW("Active");
					productRepo.save(productEntity);
					return productEntity;
					
				}
				
			}
			
		
		return null;
	}
}
