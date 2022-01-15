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
	public List<Selection> getCompanyList(Selection sel) { //in student portal for displaying company is who have selected that student
		return repository.getCompanyList(sel);
	}
	public List<Selection> getselectedStudentsList(Selection sel) { // in company portal for displaying student selected list
		return repository.getselectedStudentsList(sel);
	}
	public List<Selection> getAppliedStudentsList(Selection sel) {//in company for displaying students not selected but have applied
		return repository.getAppliedStudentsList(sel);
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
