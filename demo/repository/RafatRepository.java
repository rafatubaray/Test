package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.RafatEntity;

public interface RafatRepository extends JpaRepository<RafatEntity, Long> {

	@Query(value="select * from practice where first_name=?",nativeQuery=true)
	List<String> savefirstname(String first_name);
	
}
