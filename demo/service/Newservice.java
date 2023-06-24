package com.example.demo.service;

import com.example.demo.dto.Newentitydto;
import com.example.demo.entity.NewEntity;

public interface Newservice {

	NewEntity savedata(Newentitydto newentitydto);
	NewEntity save(NewEntity Ne);
	NewEntity update(Newentitydto nedto);
	
	void delete(Long id);
	
}
