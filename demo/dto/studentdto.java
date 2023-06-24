package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class studentdto {
	private Long id;
	private String name;
	 private String arabicName;
	private String email;
	private String phone;
	private String address;
}
