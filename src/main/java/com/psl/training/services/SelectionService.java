package com.psl.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.model.Selection;
import com.psl.training.model.Student;
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
	public List<Selection> getSelectionByIsapp() {
		return repository.getSelectionapply();
	}
	public List<Selection> getSelectionByIsselect() {
		return repository.getSelectionselect();
	}
	public void insertSelection(Selection sel) {
		repository.addSelection(sel);
	}
	public int updateSelections(Selection sel)
	{
		int flag=0;
		 flag=repository.updateSelection(sel);
		 if(flag==1)
			 return flag;
		 return 0;
	}
	
/*	public List<Student> getEmployesByDepartment(String deptname) {
		return repository.getEmployeesByDepartment(deptname);
	} */
}
