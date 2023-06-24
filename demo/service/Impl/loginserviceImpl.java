package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.MailUtility.MailUtility;
import com.example.demo.dto.Logindto2;
import com.example.demo.dto.Updatepassdto;
import com.example.demo.dto.logindto;
import com.example.demo.entity.Loginform;
import com.example.demo.repository.loginRepository;
import com.example.demo.service.loginservice;
@Service
public class loginserviceImpl implements loginservice{
	
	@Autowired
	loginRepository lRepository;
	
	@Autowired
	 private MailUtility MailUtils;
	
	@Value("${demo.url}")
	private String url;

	@Value("${demo.url1}")
	private String url1;

	@Override
	public void saveData(logindto ldt) {
		Loginform lform = new Loginform (0l,ldt.getFirstName(),ldt.getLastName(),ldt.getEmailid(),
				ldt.getUsername(),ldt.getPassword());
		
		MailUtility MailUtils= new MailUtility();
		MailUtils.sendSimpleMessage(ldt.getEmailid(),"Password set link" , url+ldt.getEmailid()+url1);
		lform = lRepository.save(lform);
	}

	@Override
	public void getAlldata(Loginform Ldt) {
		lRepository.save(Ldt);
		
	}

	@Override
	public void updatepass(Logindto2 ldt2) {
		Loginform lform = new Loginform();
		lRepository.findByEmailid(ldt2.getEmailid());
		lform.setPassword(ldt2.getPassword());
		lRepository.save(lform);
		
		
	}
}
