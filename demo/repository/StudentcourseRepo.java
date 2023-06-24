package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entity.Studentscourse;

public interface StudentcourseRepo extends JpaRepository<Studentscourse, Long>{
	
	@Query(value="select * from Studentscourse where coursename=?",nativeQuery=true )
	List<String>getstudent(String coursename);
	
	Optional<Studentscourse> findById(Long id);

}
