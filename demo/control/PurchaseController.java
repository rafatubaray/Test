package com.example.demo.control;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductListDto;
import com.example.demo.dto.Purchasedto;
import com.example.demo.dto.Vendordto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.PurchaseEntity;
import com.example.demo.entity.VendorEntity;
import com.example.demo.helper.MyExcelHelper;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.service.PurchaseService;

@CrossOrigin
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseRepository pRepository;
	
    @Autowired
	PurchaseService pservice;
	
	@PostMapping("/psave")
	public PurchaseEntity save (@Valid @RequestBody PurchaseEntity Pe) {
	return this.pservice.save(Pe);
	}

	@PostMapping("/saveinfo")
	public void saveinfo(@Valid @RequestBody Purchasedto PDT,ProductListDto pD,Vendordto vDt) {
		pservice.saveinfo(PDT);
		pservice.saveList(pD);
		pservice.SaveVendor(vDt);
	}
	
	@PostMapping("/saveproduct")
	public void saveProduct(@Valid @RequestBody ProductDto pD)throws Exception {
	this.pservice.saveproduct(pD); 
	}
	
	@PostMapping("/savevendor")
	public VendorEntity savevendor(@Valid @RequestBody Vendordto vDt) {
	return this.pservice.SaveVendor(vDt); 
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload (@RequestParam("file") MultipartFile file){
		if(MyExcelHelper.checkExcelFormat(file))
		{
			//true
			this.pservice.save(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded and data is saved to DB"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
	}
	
}
