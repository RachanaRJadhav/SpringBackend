package com.psl.training.repository;
import java.util.ArrayList;
//import com.psl.training.model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Selection;
import com.psl.training.model.Student;


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
	@Override
	
	
	public  Selection getSelectionById(int id) {
		
		Session session=sessionFactory.openSession();
		return session.get(Selection.class, id);
		
	}
	


	@Override
	public void addSelection(Selection sel) {
		
// Programmatic way of managing transactions

	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(sel);
	session.getTransaction().commit();
		
	}

	
	@Override
	@Modifying(clearAutomatically = true)
	public void updateSelection1(Selection sel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Selection> sList= session.createQuery("from Selection").list();
		for(Selection currentSelection: sList)
		{
			if(currentSelection.getStd_id() == sel.getStd_id() && currentSelection.getComp_id() == sel.getComp_id() && currentSelection.getIs_applied() == 1)
			{
				 currentSelection.setIs_select(sel.getIs_select());
			}	
		 }
		session.getTransaction().commit();
		session.close();
		
 }

	@Override
	public void delete(int id) {
		
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		List<Selection> sList= session.createQuery("from Selection").list();
//		
//		for(Selection currentSelection: sList)
//		{
//			if(currentSelection.getStd_id() == id)
//			{
////				 currentSelection.deletById(id);
//			}	
//		 }
//		session.getTransaction().commit();
//		session.close();
		
	}
	
	
	@Override
	public List<Selection> getCompanyList(int id)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Selection s1 = new Selection();
		List<Selection> selList= session.createQuery("from Selection").list();
		List<Selection> s2 =  new ArrayList<Selection>();
		for(Selection currentSelection: selList)
		{
			if( currentSelection.getStd_id()== id && currentSelection.getIs_select()==1 && currentSelection.getIs_applied()==1)
			{
			
			 s2.add(currentSelection);
			}
		
		}
		 
		return s2;
	}

	@Override
	public List<Selection> getselectedStudentsList(int id )
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Selection s1 = new Selection();
		List<Selection> selList= session.createQuery("from Selection").list();
		List<Selection> s2 =  new ArrayList<Selection>();
		for(Selection currentSelection: selList)
		{
			if( currentSelection.getComp_id()== id   && currentSelection.getIs_select()==1 && currentSelection.getIs_applied()==1)
			{
			
			 s2.add(currentSelection);
			}
		
		}
		 
		return s2;
	}


	@Override
	public List<Selection> getAppliedStudentsList(int id)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Selection s1 = new Selection();
		List<Selection> selList= session.createQuery("from Selection").list();
		List<Selection> s2 =  new ArrayList<Selection>();
		for(Selection currentSelection: selList)
		{
			if( currentSelection.getComp_id()==id   && currentSelection.getIs_select()==0 && currentSelection.getIs_applied()==1)
			{
			
			 s2.add(currentSelection);
			}
		
		}
		 
		return s2;
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
