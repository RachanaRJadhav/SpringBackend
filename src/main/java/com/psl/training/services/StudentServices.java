package com.psl.training.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.model.Student;
import com.psl.training.repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	StudentRepository repository;
	
	public List<Student> getAllStudents() {
		return repository.getAllStudents();
	}
	
	public Student getStudentsById(int id) {
		return repository.getStudentById(id);
	}
	
	public void insertStudent(Student student) {
		repository.addStudent(student);
	}
	public void updateStudents(Student std)
	{
		 repository.updateStudent(std);
	}
	public void deleteStudents(int id)
	{
		 repository.deleteStudent(id);
	}
/*	public List<Student> getEmployesByDepartment(String deptname) {
		return repository.getEmployeesByDepartment(deptname);
	} */
}
