package com.supermarket.services;

import java.util.List;
import java.util.Map;

import com.supermarket.models.CategoryEntity;
import com.supermarket.models.SubCategoryEntity;

public interface CategoryDetails {
	
	public boolean saveCategory(CategoryEntity categoryEntity);
	
	public Map<Integer, String> getCategory();
	
	public boolean saveSubCategory(SubCategoryEntity subCategoryEntity);
	
	List<SubCategoryEntity> getSubCategoryEntity();

}
