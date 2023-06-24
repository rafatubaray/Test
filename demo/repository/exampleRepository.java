package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DemoEntity;

@Repository
public interface exampleRepository extends JpaRepository<DemoEntity, Long> {
	List<DemoEntity> findAll();
	
	@Query(value="select * from Example where email_id=?", nativeQuery=true)
	List<String> getAlldata(String email);
	
	
	Optional<DemoEntity> findById(Long id);
}
