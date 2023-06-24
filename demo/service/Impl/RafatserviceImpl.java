package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Rafatdto;
import com.example.demo.entity.RafatEntity;
import com.example.demo.repository.RafatRepository;
import com.example.demo.service.Rafatservice;
@Service
public class RafatserviceImpl implements Rafatservice{
	@Autowired
	RafatRepository rRepository; 
	
	@Autowired
	Rafatservice rService;

	@Override
	public RafatEntity savedata(Rafatdto rdto) {
	RafatEntity rafatentity= new RafatEntity(0l,rdto.getFirstName(),rdto.getLastName(),rdto.getAddress());
	rafatentity=rRepository.save(rafatentity);
	return rafatentity;
	}

	@Override
	public RafatEntity save(RafatEntity rentity) {
		rRepository.save(rentity);
		return rentity;
	}

	@Override
	public RafatEntity update(Rafatdto rDt) {
		RafatEntity rEntity =new RafatEntity(rDt.getId(),rDt.getFirstName(),rDt.getLastName(),rDt.getAddress());
		rEntity=rRepository.save(rEntity);
		return rEntity;
	}

	@Override
	public void delete(Long id) {
		Optional<RafatEntity>deldata=rRepository.findById(id);
		rRepository.delete(deldata.get());
	}

	@Override
	public RafatEntity saveList(Rafatdto Rdt) {

			
			
				RafatEntity rafatentity= new RafatEntity(0l,Rdt.getFirstName(),Rdt.getLastName(),Rdt.getAddress());
				rafatentity=rRepository.save(rafatentity);
				return rafatentity;
			
			
		
		
		
	}

}
