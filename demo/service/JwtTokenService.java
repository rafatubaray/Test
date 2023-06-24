package com.example.demo.service;

import com.example.demo.MailUtility.JwtTokenManager;
import com.example.demo.dto.JwtTokenDto;
import com.example.demo.entity.JwtToken;

public interface JwtTokenService {
	
	JwtToken save(JwtToken JwtToken);
	JwtTokenDto findByid(Long id);

}
