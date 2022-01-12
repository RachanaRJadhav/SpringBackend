package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Selection;
import com.psl.training.services.SelectionService;

@RequestMapping("/api1")
@RestController
public class SelectionController {

	@Autowired
	SelectionService service;
	
	@GetMapping("/selections")
	public List<Selection> getSelections(){
		return service.getAllSelections();
		
	}
	@PostMapping("/selections")
	public String insertSelection(@RequestBody Selection sel){		
		 service.insertSelection(sel);
		return "Selection table created sucessfully";
	}
}
