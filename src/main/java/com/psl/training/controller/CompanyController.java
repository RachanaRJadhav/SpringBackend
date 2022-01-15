package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Company;
import com.psl.training.model.Student;
import com.psl.training.services.CompanyService;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins="http//localhost:3000")
public class CompanyController {

	@Autowired
	CompanyService service;
	
	@GetMapping("/companies")
	public List<Company> getCompanies(){
		return service.getAllCompanies();
		
	}
	@GetMapping("/companies/{id}")
	public Company getCompaniesById(@PathVariable int id){
		return service.getCompaniesById(id);
		
	}
	@PostMapping("/companies")
	public String insertCompany(@RequestBody Company comp){		
		 service.insertCompany(comp);
		return "compnytable created sucessfully";
	}
}
