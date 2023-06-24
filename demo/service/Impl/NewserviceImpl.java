package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Demoentitydto;
import com.example.demo.dto.Newentitydto;

import com.example.demo.entity.NewEntity;
import com.example.demo.repository.NewRepository;
import com.example.demo.service.Newservice;
@Service
public class NewserviceImpl implements Newservice {
	@Autowired
	NewRepository newRepository;
	
	
	@Override
	public NewEntity savedata(Newentitydto ned) {
		NewEntity newEntity= new NewEntity(0l,ned.getCol1(),ned.getCol2());
		newEntity=newRepository.save(newEntity);
		return newEntity;
	}

	@Override
	public NewEntity save(NewEntity Ne) {
		newRepository.save(Ne);
		return Ne;
	}

	@Override
	public NewEntity update(Newentitydto nedto) {
		NewEntity newEntity= new NewEntity(nedto.getId(),nedto.getCol1(),nedto.getCol2());
		newEntity=newRepository.save(newEntity);
		return newEntity;
	}

	@Override
	public void delete(Long id) {
	 Optional<NewEntity> newdata=newRepository.findById(id);
	 newRepository.delete(newdata.get());
		
	}

	
	

	

}
