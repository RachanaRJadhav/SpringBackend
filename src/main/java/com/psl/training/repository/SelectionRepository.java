package com.psl.training.repository;

import java.util.List;

import com.psl.training.model.Selection;

public interface SelectionRepository {
	public List<Selection> getAllSelections() ;
	public Selection getSelectionById(int id);
	public void  deleteSelection(int id);
	public void  addSelection(Selection sel);
	//public List<Student> getStudentsByDepartment(String deptName);
}
