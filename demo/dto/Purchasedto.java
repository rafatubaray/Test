package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchasedto {
	private Long id;
	
	@NotEmpty(message="Please Enter the value!")
	private String vendor_name;
	
	@NotEmpty(message="Please Enter the value!")
	private Long invoice_no;
	
	@NotEmpty(message="Please Enter the value!")
	private String reference;
	
	@NotEmpty(message="Please Enter the value!")
	private Long grand_total;
	
	@NotEmpty(message="Please Enter the value!")
	private Long discount;
	
	@NotEmpty(message="Please Enter the value!")
	private Long net_amount;
	
	@NotEmpty(message="Please Enter the value!")
	private List<ProductDto> referenceList;
	
	
	
	
}
