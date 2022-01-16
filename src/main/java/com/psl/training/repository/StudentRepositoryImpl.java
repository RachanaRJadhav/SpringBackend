package com.psl.training.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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

	public Student getStudentById(int id) 
	{
		
		Session session=sessionFactory.openSession();
		return session.get(Student.class, id);
		
	}
	@Override
	public void  addStudent(Student std) 
	{
		
// Programmatic way of managing transactions

	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(std);
	session.getTransaction().commit();


		
	}


	@Override
	@Modifying(clearAutomatically = true)
	
	public void updateStudent(Student std) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		List<Student> stdList= session.createQuery("from Student").list();
		boolean exist1 = false;
		for(Student currentStudent: stdList)
		{
			if(currentStudent.getStd_id()==std.getStd_id())
			{
			exist1=true;
			currentStudent.setCgpa(std.getCgpa());
			currentStudent.setT_skills(currentStudent.getT_skills() + "\t " +std.getT_skills());
		     }
		}
		if(!exist1) {
			stdList.add(std);
			
		}
		session.getTransaction().commit();
		session.close();
		
	}
	

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
//	@Override
	/*public void deleteStudent(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//Query qry=session.createQuery("delete from student where std_id=:i");
		//qry.setParameter("i", id );
		////int status=qry.executeUpdate();
		//session.update()
		Student s1=session.get(Student.class, id);
		session.delete(s1);
		session.getTransaction().commit();
		
	}*/

	
	/* @Override
	public List<Students> getStudentsByDepartment(String deptName) {
		Session session=sessionFactory.openSession();
		Query qry=session.createQuery("FROM Employee e where department.deptName like  :dept_name ");
		qry.setParameter("dept_name", deptName);
		return qry.list();
	}
	*/
}
