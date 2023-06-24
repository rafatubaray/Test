package com.example.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Newentitydto;
import com.example.demo.dto.Rafatdto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.NewEntity;
import com.example.demo.entity.RafatEntity;
import com.example.demo.repository.RafatRepository;
import com.example.demo.service.Rafatservice;

@CrossOrigin
@RestController
@RequestMapping("/practice")
public class RafatController {
	
    @Autowired
	RafatRepository rRepository;
    
    @Autowired
    Rafatservice rService;

@PostMapping("/savedata")
public RafatEntity savedata(@RequestBody Rafatdto rdto) {
return this.rService.savedata(rdto);
}

@PostMapping("/save")
public RafatEntity save(@RequestBody RafatEntity rentity) {
return this.rService.save(rentity);
}

@PostMapping("/update")
public RafatEntity update(@RequestBody Rafatdto rDt) {
return this.rService.update(rDt);
}

@DeleteMapping("/delete")
public void delete(@RequestParam(value="id")Long id) {
rService.delete(id);
}


@PostMapping("/duplicate")
public ResponseDto< RafatEntity> saveList(@RequestBody Rafatdto Rdt) {
	ResponseDto<RafatEntity>rsDto= new ResponseDto<>();
	int statusCode;
	List<String> checkvalue = rRepository.savefirstname(Rdt.getFirstName());
	if(checkvalue.isEmpty())
	{
	RafatEntity Re= rService.saveList(Rdt);	
	statusCode=HttpStatus.OK.value();
	rsDto.setStatusCode(statusCode);
	rsDto.setMessage("created Successfully!");
	rsDto.setData(Re);
	}
	else
	{
		statusCode=HttpStatus.IM_USED.value();
		rsDto.setStatusCode(statusCode);
		rsDto.setMessage("User Already Exist!");
	}
	return rsDto;
   }
}
