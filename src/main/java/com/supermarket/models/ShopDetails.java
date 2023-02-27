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
@Table(name = "Shop_Details")
@Data
@Getter
@Setter
public class ShopDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer shopCode;

	public String name;

	public String gst;

	public String phone;

	public String email;

	public String password;

	public String activeSW;
	
	@OneToOne
	@JoinColumn(name = "add_Id")
	public AddressDetails addressDetails;

}
