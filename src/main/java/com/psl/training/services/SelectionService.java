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
