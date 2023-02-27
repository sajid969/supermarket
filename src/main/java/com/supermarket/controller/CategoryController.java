package com.supermarket.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.models.CategoryEntity;
import com.supermarket.models.SubCategoryEntity;
import com.supermarket.services.CategoryDetails;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryDetails catServices;
	
	@PostMapping("/category")
	public ResponseEntity<String> createCategory(@RequestBody CategoryEntity categoryEntity){
		boolean saveCategory = catServices.saveCategory(categoryEntity);
		if(saveCategory) {
			return new ResponseEntity<String>("Category Inserted successfully", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Category Not Inserted successfully", HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/category")
	public ResponseEntity<Map<Integer, String>> getCategory(){
		Map<Integer,String> category = catServices.getCategory();
		return new ResponseEntity<Map<Integer,String>>(category, HttpStatus.OK);
	}
	
	@PostMapping("/subcategory")
	public ResponseEntity<String> createSubCategory(@RequestBody SubCategoryEntity subCategoryEntity){
		boolean saveSubCategory = catServices.saveSubCategory(subCategoryEntity);
		if(saveSubCategory) {
			return new ResponseEntity<String>("SubCategory Inserted successfully", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("SubCategory Not Inserted successfully", HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/subcategory")
	public ResponseEntity<List<SubCategoryEntity>> getSubCategory(){
		List<SubCategoryEntity> category = catServices.getSubCategoryEntity();
		return new ResponseEntity<List<SubCategoryEntity>>(category, HttpStatus.OK);
	}
	

}
