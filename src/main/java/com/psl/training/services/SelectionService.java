package com.psl.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.model.Selection;
import com.psl.training.repository.SelectionRepository;

@Service
public class SelectionService {

	@Autowired
	SelectionRepository repository;
	
	public List<Selection> getAllSelections() {
		return repository.getAllSelections();
	}
	
	public Selection getSelectionsById(int id) {
		return repository.getSelectionById(id);
	}
	public void insertSelection(Selection sel) {
		repository.addSelection(sel);
	}
	public void updateSelections(int id,short is_select)
	{
		 repository.updateSelection(id,is_select);
	}
	
/*	public List<Student> getEmployesByDepartment(String deptname) {
		return repository.getEmployeesByDepartment(deptname);
	} */
}
