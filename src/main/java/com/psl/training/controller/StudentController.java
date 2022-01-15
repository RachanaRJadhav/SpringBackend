package com.psl.training.controller;
import com.psl.training.repository.StudentRepository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Student;
import com.psl.training.services.StudentServices;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins="http//localhost:3000")
public class StudentController {

	@Autowired
	StudentServices service;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return service.getAllStudents();
		
	}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable("id")int id){
		return service.getStudentsById(id);
		
	}
	@PostMapping("/students")
	public String insertStudent(@RequestBody Student std){		
		 service.insertStudent(std);
		return "Student created sucessfully";
	}
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student std )
	{		
	
	    service.updateStudents(std);
		return "Student updated sucessfully";
		
	}
	/*@DeleteMapping("/students")
	public String deleteStudent(@RequestParam int id){		
		 service.deleteStudents(id);
		return "Student created sucessfully";
	}*/
}

