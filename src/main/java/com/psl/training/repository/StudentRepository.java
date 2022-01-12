package com.psl.training.repository;

import java.util.List;

import com.psl.training.model.Student;

public interface StudentRepository {
	public List<Student> getAllStudents() ;
	public Student getStudentById(int id);
	public void  deleteStudent(int id);
	public void  addStudent(Student std);
	//public List<Student> getStudentsByDepartment(String deptName);
}
