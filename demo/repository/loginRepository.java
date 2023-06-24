package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loginform;
@Repository
public interface loginRepository extends JpaRepository<Loginform, Long> {

	@Query(value= "SELECT * FROM login WHERE username='?' AND password='?' ", nativeQuery=true)
	List<String> getAlldata (String user_name, String Password);
	
	@Query(value= "SELECT * FROM login  WHERE emailid=?", nativeQuery=true)
	List<String> findByEmailid (String emailid );
}
