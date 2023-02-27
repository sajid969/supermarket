package com.supermarket.bindings;

import com.supermarket.models.AddressDetails;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShopDto {
	
	public String name;

	public String gst;

	public String phone;

	public String email;

	public String password;

	@OneToOne
	@JoinColumn(name = "add_Id")
	public AddressDetails addressDetails;

}
