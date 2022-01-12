package com.psl.training.repository;

import java.util.List;

import com.psl.training.model.Company;

public interface CompanyRepository {
	public List<Company> getAllCompanies() ;
	public Company getCompanyById(int id);
	public void  deleteCompany(int id);
	public void  addCompany(Company comp);
	//public List<Student> getStudentsByDepartment(String deptName);
}
