package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Student;
import com.psl.training.services.StudentServices;

@RequestMapping("/api")
@RestController
public class StudentController {

	@Autowired
	StudentServices service;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return service.getAllStudents();
		
	}
	@PostMapping("/students")
	public String insertStudent(@RequestBody Student std){		
		 service.insertStudent(std);
		return "Student created sucessfully";
	}
}
