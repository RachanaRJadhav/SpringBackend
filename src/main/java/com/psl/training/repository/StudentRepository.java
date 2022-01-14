package com.psl.training.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.psl.training.model.Student;
@Repository
public interface StudentRepository {
	public List<Student> getAllStudents() ;
	public Student getStudentById(int id);
	public void  deleteStudent(int id);
	public void updateStudent(int id,double cgpa,String T_skills);
	public void  addStudent(Student std);
	//public List<Student> getStudentsByDepartment(String deptName);
}
