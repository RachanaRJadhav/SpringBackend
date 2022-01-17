package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.psl.training.model.Company;
import com.psl.training.model.Selection;
import com.psl.training.model.Student;
import com.psl.training.services.SelectionService;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins="http//localhost:3000")
public class SelectionController {

	@Autowired
	SelectionService service;
	
	@GetMapping("/selections")
	public List<Selection> getSelections(){
		return service.getAllSelections();
		
	}
	@GetMapping("/selections/{id}")
	public Selection getSelectionById(@PathVariable int id){
		return service.getSelectionsById(id);
		
	}
	@GetMapping("/selections/selectedcompanylist/{id}")//in student portal for displaying company is who have selected that student
	public List<Selection> getCompanyList(@PathVariable int id){
		return service.getCompanyList(id);
		
	}
	@GetMapping("/selections/selectedstudentlist/{id}")// in company portal for displaying student selected list
	public List<Selection> getselectedStudentList(@PathVariable int id){
		return service.getselectedStudentsList(id);
		
	}
	
	@GetMapping("/selections/appliedstudentlist/{id}")//in company for displaying students not selected but have applied
	public List<Selection> getAppliedStudentsList(@PathVariable int id){
		return service.getAppliedStudentsList(id);
		
	}
	
	@PostMapping("/selections/insert")
	@CrossOrigin( origins = "http//localhost:3000")
	public String insertSelection(@RequestBody Selection sel){		
		 service.insertSelection(sel);
		return "Selection table created sucessfully";
	}
	
	
	@PutMapping("/selections")
	public void updateSelection1(@RequestBody Selection sel )
	{		
	   service.updateSelection1(sel);
	   
	}
	
	@DeleteMapping(value = "/selections")
    public void deletePost(@RequestBody Selection sel) {

		service.delete(sel);

    }
}
