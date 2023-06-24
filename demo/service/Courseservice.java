package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.studentcoursedto;
import com.example.demo.dto.studentdto;
import com.example.demo.entity.Studentscourse;

public interface Courseservice {
	
	void savecourse(CourseDto cdt);
	void updatecourse(CourseDto cdt);
	void delete(Long id);
	void savestudentcourse(studentcoursedto scdt);
	void updatestudentcourse(studentcoursedto scdt);
	void deleteStudent(Long id);
	void savestudent(studentdto StudentDto);

}
