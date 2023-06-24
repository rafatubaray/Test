package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CourseEntity;
@Repository
public interface CourseRepo extends JpaRepository<CourseEntity,Long>{
	
	Optional<CourseEntity> findById(Long id);
	
	@Query(value="select * from Courses where course_name=?",nativeQuery=true )
	List<String>getcourse(String course_name);

}
