package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.JwtToken;
@Repository
public interface JwtTokenRepository extends JpaRepository<JwtToken,Long>{
	
    JwtToken findByid(@Param("id")Long id);

	JwtToken findByAccessTokenAndId(String accessToken, Long id);

}
