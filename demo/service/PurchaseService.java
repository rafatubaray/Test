package com.example.demo.service;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductListDto;
import com.example.demo.dto.Purchasedto;
import com.example.demo.dto.Vendordto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.PurchaseEntity;
import com.example.demo.entity.RafatEntity;
import com.example.demo.entity.VendorEntity;

public interface PurchaseService {
	
	PurchaseEntity save(PurchaseEntity Pe);
	void saveinfo(Purchasedto pdto);
	void saveproduct(ProductDto Pd) throws Exception;
	void saveList(ProductListDto Pld);
	VendorEntity SaveVendor(Vendordto vdto);
	void save(MultipartFile file);
	List<ProductEntity> getAllProducts();
	
	
}
