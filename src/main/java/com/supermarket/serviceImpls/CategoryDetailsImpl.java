package com.supermarket.serviceImpls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.models.CategoryEntity;
import com.supermarket.models.SubCategoryEntity;
import com.supermarket.repositories.CategoryRepo;
import com.supermarket.repositories.SubCategoryRepo;
import com.supermarket.services.CategoryDetails;

@Service
public class CategoryDetailsImpl implements CategoryDetails {
	
	@Autowired
	CategoryRepo catRepo;
	
	@Autowired
	SubCategoryRepo subCatRepo;

	@Override
	public boolean saveCategory(CategoryEntity categoryEntity) {
		CategoryEntity save = catRepo.save(categoryEntity);
		return save.getCategoryId()!=null;
	}

	@Override
	public Map<Integer, String> getCategory() {
		List<CategoryEntity> findAll = catRepo.findAll();
		Map<Integer, String> catMap = new HashMap<>();
		findAll.forEach(cat->catMap.put(cat.getCategoryId(), cat.getCategoryName()));
		return catMap;
	}

	@Override
	public boolean saveSubCategory(SubCategoryEntity subCategoryEntity) {
		SubCategoryEntity save = subCatRepo.save(subCategoryEntity);
		return save.getSubCategoryId()!=null;
	}

	@Override
	public List<SubCategoryEntity> getSubCategoryEntity() {
		List<SubCategoryEntity> findAll = subCatRepo.findAll();
		return findAll;
	}

}
