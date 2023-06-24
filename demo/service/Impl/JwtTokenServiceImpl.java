package com.example.demo.service.Impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JwtTokenDto;
import com.example.demo.entity.JwtToken;
import com.example.demo.repository.JwtTokenRepository;
import com.example.demo.service.JwtTokenService;


@Service
@Transactional
public class JwtTokenServiceImpl implements JwtTokenService {

	@Autowired
	JwtTokenRepository jwtTokenRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public JwtToken save(JwtToken JwtToken) {
		return jwtTokenRepository.save(JwtToken);
	}

	@Override
	public JwtTokenDto findByid(Long id) {
		JwtToken jwtToken = jwtTokenRepository.findByid(id);
		return modelMapper.map(jwtToken, JwtTokenDto.class);
	}

}
