package com.psl.training.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	

	@Autowired
	SessionFactory sessionFactory;

	public List<Student> getAllStudents() {

		Session session=sessionFactory.openSession();
		List<Student> stdList= session.createQuery("from Student").list();
		System.out.println(stdList.size());
		session.close();
		return stdList;
	}

	public Student getStudentById(int id) {
		
		Session session=sessionFactory.openSession();
		return session.get(Student.class, id);
		
	}
	@Override
	public void  addStudent(Student std) {
		
// Programmatic way of managing transactions

	Session session=	sessionFactory.openSession();
	session.beginTransaction();
	session.save(std);
	session.getTransaction().commit();


		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	/* @Override
	public List<Students> getStudentsByDepartment(String deptName) {
		Session session=sessionFactory.openSession();
		Query qry=session.createQuery("FROM Employee e where department.deptName like  :dept_name ");
		qry.setParameter("dept_name", deptName);
		return qry.list();
	}
	*/
}
