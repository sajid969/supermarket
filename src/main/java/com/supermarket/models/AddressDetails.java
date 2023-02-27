package com.supermarket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Address_Details")
@Data
@Getter
@Setter
public class AddressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer add_Id;

	public String flatNo;

	public String building;

	public String streetName;

	public String area;

	public String district;

	public String state;

	public Integer pinCode;
	

}
