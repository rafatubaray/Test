package com.example.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Logindto2;
import com.example.demo.dto.Rafatdto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.Updatepassdto;
import com.example.demo.dto.logindto;
import com.example.demo.entity.Loginform;
import com.example.demo.entity.RafatEntity;
import com.example.demo.repository.loginRepository;
import com.example.demo.service.loginservice;

@CrossOrigin
@RestController
@RequestMapping("/Login")

public class LoginController {
	
	@Autowired
	loginRepository lRepository;
	
	@Autowired
	loginservice lservice;
	
	@PostMapping("/signup")
	public void saveData(@RequestBody logindto ldto) {
		lservice.saveData(ldto);
	}
	
	@GetMapping("/getdata")
	public ResponseDto<Loginform> getAlldata(HttpServletResponse httpServletResponse, @RequestParam(value="username")String username,@RequestParam(value="password")String password, Logindto2 Ldt) {
		ResponseDto<Loginform>rsDto= new ResponseDto<>();
		int statusCode;
		List<String> checkvalue = lRepository.getAlldata(username,password);
		if(!checkvalue.isEmpty())
		{	
		statusCode=HttpStatus.OK.value();
		rsDto.setStatusCode(statusCode);
		rsDto.setMessage("Login Successful!");
	
		}
		
		else 
		{
			statusCode=HttpStatus.NOT_FOUND.value();
			rsDto.setStatusCode(statusCode);
			rsDto.setMessage("Login Failed!");
		}
		return rsDto;
		
	}
	
	@PostMapping("/updatepass")
	public  void updatepass(@RequestBody Logindto2 ldt2) {
	
		 this.lservice.updatepass(ldt2);
		
		
		
		
		
	}

}
