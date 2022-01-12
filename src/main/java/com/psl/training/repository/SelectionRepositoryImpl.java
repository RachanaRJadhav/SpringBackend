package com.psl.training.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Selection;


@Repository
public class SelectionRepositoryImpl implements SelectionRepository {
	

	@Autowired
	SessionFactory sessionFactory;

	public List<Selection> getAllSelections() {

		Session session=sessionFactory.openSession();
		List<Selection> selList= session.createQuery("from Selection").list();
		System.out.println(selList.size());
		session.close();
		return selList;
	}

	public Selection getSelectiontById(int id) {
		
		Session session=sessionFactory.openSession();
		return session.get(Selection.class, id);
		
	}
	@Override
	public void addSelection(Selection sel) {
		
// Programmatic way of managing transactions

	Session session=	sessionFactory.openSession();
	session.beginTransaction();
	session.save(sel);
	session.getTransaction().commit();


		
	}

	@Override
	public void deleteSelection(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Selection getSelectionById(int id) {
		// TODO Auto-generated method stub
		return null;
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
