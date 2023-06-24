package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	
	private Long invoice_no;
	
	private String product_pre;
	
	private String product_name;

	private Long quantity;
	
	private Long rate;
	
	private Long total;
	
	

}
