package com.psl.training.repository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.psl.training.model.Selection;

public interface SelectionRepository {
	public List<Selection> getAllSelections() ;
	public Selection getSelectionById(int id);
	public List<Selection> getCompanyList(int id);
	public List<Selection> getselectedStudentsList(int id);
	public List<Selection> getAppliedStudentsList(int id);
	
	public void  addSelection(Selection sel);
	public void updateSelection1(Selection sel);
	public void delete(Selection sel);
}
