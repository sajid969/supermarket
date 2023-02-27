package com.supermarket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Product")
@Data
@Getter
@Setter
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productId;
	
	public String productName;
	
	public float actualPrice;
	
	public Integer discount;
	
	public float finalPrice;
	
	public String activeSW;
	
	@OneToOne
	@JoinColumn(name = "description_id")
	public ProductDescription productDescription;
	
	public Integer categoryEntity;
	
	public Integer subCategoryEntity;
	
	public Integer shopDetails;

}
