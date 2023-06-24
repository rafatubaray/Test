package com.example.demo.service;

import com.example.demo.dto.Logindto2;
import com.example.demo.dto.Updatepassdto;
import com.example.demo.dto.logindto;
import com.example.demo.entity.Loginform;

public interface loginservice {
	
	void saveData(logindto ldt);
	void getAlldata(Loginform Ldt);
	void updatepass(Logindto2 ldt2);
	

}
