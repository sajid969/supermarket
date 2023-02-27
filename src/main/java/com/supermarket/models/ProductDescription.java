package com.supermarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Prod_Spec")
@Data
@Getter
@Setter
public class ProductDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer descriptionId;
	
	public String prodColour;
	@Column(name="specification", length =1000)
	public String speccification;

}
