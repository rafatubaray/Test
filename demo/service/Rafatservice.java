package com.example.demo.service;

import com.example.demo.dto.Rafatdto;
import com.example.demo.entity.RafatEntity;

public interface Rafatservice {

	RafatEntity savedata(Rafatdto rafatdto);
	RafatEntity save(RafatEntity rentity);
	RafatEntity update(Rafatdto rDt);
	RafatEntity saveList (Rafatdto Rdt);
	void delete(Long id);
}
