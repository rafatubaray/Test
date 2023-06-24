package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Newentitydto;
import com.example.demo.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	
	List<NewEntity> findByCol1(String col1);

	NewEntity save(Newentitydto ned);
	
	Optional<NewEntity> findById(Long Id);

}
