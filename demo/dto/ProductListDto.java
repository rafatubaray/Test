package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductListDto {
	@NotEmpty(message="Please Enter the value!")
	private List<ProductDto> referenceList;
}
