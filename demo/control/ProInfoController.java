package com.example.demo.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Rafatdto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.PurchaseEntity;
import com.example.demo.entity.RafatEntity;
import com.example.demo.entity.VendorEntity;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.Rafatservice;

@CrossOrigin
@RestController
@RequestMapping("/map")

public class ProInfoController {
	@Autowired
	PurchaseRepository PURepository;
	
	
	@GetMapping("/PurInfo")
	public List<String> purchase(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id)
	{
		return PURepository.getAlldata(id);
	}
	
	@GetMapping("/ProInfo")
	public List<String> product(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id)
	{
		return PURepository.getAlldata1(id);
	}
	
	@GetMapping("/PracInfo")
	public List<String> practice(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id)
	{
		return PURepository.getAlldata2(id);
	}
	
	@GetMapping("/VenInfo")
	public List<String> vendor(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id)
	{
		return PURepository.getAlldata3(id);
	}
	
	@GetMapping("/Merge")
	public  Map<String, Object> Collection(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id)
	{
	Map<String, Object> map = new HashMap<>();
	List<String> CollectionList = PURepository.getAlldata(id);
	List<String> CollectionList1 = PURepository.getAlldata1(id);
	List<String> CollectionList2 = PURepository.getAlldata2(id);
	List<String> CollectionList3 = PURepository.getAlldata3(id);
	map.put("Purchase",CollectionList);
	map.put("Product",CollectionList1);
	map.put("Practiice",CollectionList2);
	map.put("Vendor",CollectionList3);
	return map;
	}
	
	
}
