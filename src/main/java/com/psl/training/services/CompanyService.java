package com.psl.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.model.Company;
import com.psl.training.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository repository;
	
	public List<Company> getAllCompanies() {
		return repository.getAllCompanies();
	}
	
	public Company getCompaniesById(int id) {
		return repository.getCompanyById(id);
	}
	public void insertCompany(Company comp) {
		repository.addCompany(comp);
	}
	
/*	public List<Student> getEmployesByDepartment(String deptname) {
		return repository.getEmployeesByDepartment(deptname);
	} */
}
