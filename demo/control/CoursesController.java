package com.example.demo.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.Header;
import com.example.demo.dto.logindto;
import com.example.demo.dto.studentcoursedto;
import com.example.demo.dto.studentdto;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.StudentcourseRepo;
import com.example.demo.service.Courseservice;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin
@RestController
@RequestMapping("/Course")
public class CoursesController {
	
	@Autowired
	CourseRepo cRepo;
	
	@Autowired
	Courseservice cservice;
	
	@Autowired 
	StudentcourseRepo scRepo;
	 
	 @Autowired
	 StudentRepo sRepo;
	 
	 private Header getHeader(HttpHeaders httpHeaders) {
			Header header = new Header();
			Map<String, String> headerMap = httpHeaders.toSingleValueMap();
			final ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			return header;
		}
	
	@PostMapping("/addCourse")
	public void savecourse(@RequestHeader(value = "accessToken") String accessToken,@RequestBody CourseDto cdto) {
		this.cservice.savecourse(cdto);
	}
	
	@PostMapping("/updateCourse")
	public void update(@RequestHeader(value = "accessToken") String accessToken,@RequestBody CourseDto cdto) {
		this.cservice.updatecourse(cdto);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestHeader(value = "accessToken") String accessToken,@RequestParam(value="id")Long id) {
		this.cservice.delete(id);
	}
	
	@GetMapping("/getCourse")
	public List<String> getcourse(@RequestHeader(value = "accessToken") String accessToken,HttpServletResponse httpServletResponse,@RequestParam(value="course_name")String course_name) {
		return cRepo.getcourse(course_name);
	}
    
	@PostMapping("/addStudent")
	public void savestudent(@RequestHeader(value = "accessToken") String accessToken,@RequestBody studentdto st)
	{
		this.cservice.savestudent(st);
	}
	
	@PostMapping("/allocate_course")
	public void allocatecourse(@RequestHeader(value = "accessToken") String accessToken,@RequestBody studentcoursedto scdto) {
		this.cservice.savestudentcourse(scdto);
	}
	
	@GetMapping("/getStudent")
	public List<String> getStudent(@RequestHeader(value = "accessToken") String accessToken,HttpServletResponse httpServletResponse,@RequestParam(value="coursename")String coursename) {
		return this.scRepo.getstudent(coursename);
	}
	
	@PostMapping("/updatestudentCourse")
	public void updatestudentCourse(@RequestHeader(value = "accessToken") String accessToken,@RequestBody studentcoursedto scdto) {
		this.cservice.updatestudentcourse(scdto);
	}
	
	@DeleteMapping("/deletestudent")
	public void deletestudent(@RequestHeader(value = "accessToken") String accessToken,@RequestParam(value="id")Long id) {
		this.cservice.deleteStudent(id);
	}
	
}
