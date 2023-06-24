package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.studentcoursedto;
import com.example.demo.dto.studentdto;
import com.example.demo.entity.CourseEntity;
import com.example.demo.entity.Student;
import com.example.demo.entity.Studentscourse;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.StudentcourseRepo;
import com.example.demo.service.Courseservice;
 @Service
public class CourseserviceImpl implements Courseservice {
	 @Autowired
	 CourseRepo cRepo;
	 
	 @Autowired
	 StudentcourseRepo scRepo;
	 
	 @Autowired
	 StudentRepo sRepo;

	@Override
	public void savecourse(CourseDto cdt) {
		
		CourseEntity ce = new CourseEntity(0l,cdt.getCourse_name(),cdt.getCourse_details());
		this.cRepo.save(ce);
	}

	@Override
	public void updatecourse(CourseDto cdt) {
		CourseEntity CE= new CourseEntity(cdt.getId(),cdt.getCourse_name(),cdt.getCourse_details());
		this.cRepo.save(CE);
		
	}

	@Override
	public void delete(Long id) {
		Optional<CourseEntity>delcourse=cRepo.findById(id);
		cRepo.delete(delcourse.get());
		
	}

	@Override
	public void savestudentcourse(studentcoursedto scdt) {
		Studentscourse sc= new Studentscourse(01,scdt.getStudentname(),scdt.getCoursename());
		this.scRepo.save(sc);
		
		
	}

	@Override
	public void updatestudentcourse(studentcoursedto scdt) {
		Studentscourse SC= new Studentscourse(scdt.getId(),scdt.getStudentname(),scdt.getCoursename());
		this.scRepo.save(SC);
		
	}

	@Override
	public void deleteStudent(Long id) {
		Optional<Studentscourse>deleteStudent=scRepo.findById(id);
		scRepo.delete(deleteStudent.get());
		
	}

	@Override
	public void savestudent(studentdto StudentDto) {
		Student s= new Student(01,StudentDto.getName(),StudentDto.getArabicName(),StudentDto.getEmail(),StudentDto.getPhone(),StudentDto.getAddress());
		this.sRepo.save(s);
	}

}
