package com.example.demo.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductListDto;
import com.example.demo.dto.Purchasedto;
import com.example.demo.dto.Vendordto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.PurchaseEntity;
import com.example.demo.entity.RafatEntity;
import com.example.demo.entity.VendorEntity;
import com.example.demo.helper.MyExcelHelper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.PurchaseService;

@Service
public class PurchaseserviceImpl  implements PurchaseService{
	@Autowired
	PurchaseRepository pRepository;
	
	@Autowired
	ProductRepository prRepository;
	
	@Autowired
	VendorRepository vRepository;

	@Override
	public PurchaseEntity save(PurchaseEntity pe) {
		pRepository.save(pe);
		return pe;
	}

	@Override
	public void saveinfo(Purchasedto pdto) {
		
		for(ProductDto prdt : pdto.getReferenceList()) {
		PurchaseEntity PE= new PurchaseEntity(0l,pdto.getVendor_name(),pdto.getInvoice_no(),
				pdto.getReference(),prdt.getProduct_name(),prdt.getQuantity(),prdt.getRate(),
				prdt.getTotal(),pdto.getGrand_total(),pdto.getDiscount(),pdto.getNet_amount());
		}
	}

	@Override
	public void saveproduct(ProductDto Pd)throws Exception {
		List<String> invoice= pRepository.getinvoice();
		Long a,c;
		String b;
		a= Long.parseLong(invoice.get(0));
		c=a+1;
		b="Pr--"+c.toString();
		
		if(!Pd.getProduct_name().isEmpty() && !Pd.getQuantity().equals(null) && !Pd.getRate().equals(null)
				&& !Pd.getTotal().equals(0))
		{
		ProductEntity pE = new ProductEntity(0l,c,b,Pd.getProduct_name(),
				Pd.getQuantity(),Pd.getRate(),Pd.getTotal()); 
		pE=prRepository.save(pE);
		}
		else
		{
			throw new Exception("Please Enter All Values");
		}
	}

	@Override
	public VendorEntity SaveVendor(Vendordto vdto) {
		VendorEntity ve = new VendorEntity(0l,vdto.getVendor_name(),vdto.getInvoice_no(),
				vdto.getReference(),vdto.getNet_amount(),vdto.getDiscount(),vdto.getGrand_total()); 
		ve=vRepository.save(ve);
		return ve;
	}

	@Override
	public void saveList(ProductListDto Pld) {
		for(ProductDto prodt: Pld.getReferenceList()) {
			ProductEntity PrE = new ProductEntity(0l,prodt.getInvoice_no(),prodt.getProduct_pre(),prodt.getProduct_name(),
					prodt.getQuantity(),prodt.getRate(),prodt.getTotal());
			PrE= prRepository.save(PrE);
		}
	}

	@Override
	public void save(MultipartFile file) {
		 try {
	            List<ProductEntity> products = MyExcelHelper.convertExcelToListOfProduct(file.getInputStream());
	          
	            this.prRepository.saveAll(products);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		return this.prRepository.findAll();
	}
}
