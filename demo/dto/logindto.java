package com.example.demo.dto;

import com.example.demo.entity.Loginform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class logindto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String emailid;
	private String username;
	private String password;


}
