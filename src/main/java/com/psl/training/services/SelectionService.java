package com.psl.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	public List<Selection> getCompanyList(int id) { //in student portal for displaying company is who have selected that student
		return repository.getCompanyList(id);
	}
	public List<Selection> getselectedStudentsList(int id) { // in company portal for displaying student selected list
		return repository.getselectedStudentsList(id);
	}
	public List<Selection> getAppliedStudentsList(int id) {//in company for displaying students not selected but have applied
		return repository.getAppliedStudentsList(id);
	}
	public void insertSelection(Selection sel) {
		repository.addSelection(sel);
	}
	public void updateSelection1(Selection sel)
	{
		repository.updateSelection1(sel);	 
	}

	public void delete( Selection sel) {
		repository.delete(sel);
	}
	
/*	public List<Student> getEmployesByDepartment(String deptname) {
		return repository.getEmployeesByDepartment(deptname);
	} */
}
