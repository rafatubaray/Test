package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.Purchasedto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.PurchaseEntity;
import com.example.demo.entity.RafatEntity;
import com.example.demo.entity.VendorEntity;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {

	@Query(value= "select * from purchase_info where id= ?" , nativeQuery=true)
	List<String> getAlldata(Long id);
	
	@Query(value= "select * from product_info where id= ?" , nativeQuery=true )
	List<String> getAlldata1(Long id);
	
	@Query(value= "select * from practice where id= ?" , nativeQuery=true)
	List<String> getAlldata2(Long id);
	
	@Query(value= "select * from vendor_info where id= ?" , nativeQuery=true)
	List<String> getAlldata3(Long id);
	
	@Query(value="select MAX(invoice_no) from product_info",nativeQuery=true)
	List<String> getinvoice();
	
	
}
