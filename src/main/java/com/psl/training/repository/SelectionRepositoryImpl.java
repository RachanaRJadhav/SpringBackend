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

	Session session=	sessionFactory.openSession();
	session.beginTransaction();
	session.save(sel);
	session.getTransaction().commit();


		
	}

	
	@Override
	@Modifying(clearAutomatically = true)
	public int updateSelection(Selection sel) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//Query qry=session.createQuery("update student set cgpa=:i and T_skills=:t where std_id=:n ");
		//qry.setParameter("n", id );
		//qry.setParameter("i", cgpa );
		//qry.setParameter("t", T_skills );
		//int status=qry.executeUpdate();
		//System.out.println(status);  
		/*Selection s1=session.get(Selection.class, id);
		s1.setIs_select(is_select);
		
		session.update(s1);*/
		List<Selection> selList= session.createQuery("from Selection").list();
		int exist1 = 0;
		for(Selection currentSelection: selList)
		{
			if(currentSelection.getIs_applied()==1 && currentSelection.getStd_id()==sel.getStd_id() && currentSelection.getComp_id()==sel.getComp_id())
			{
			exist1=1;
			currentSelection.setIs_select(sel.getIs_select());
			
		     }
		}
		if(exist1==1) {
			 
			selList.add(sel);
			return exist1;
			
		}
		
		session.getTransaction().commit();
		session.close();
		return 0;
		
	}

	@Override
	public void deleteSelection(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Selection> getSelectionapply()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Selection s1 = new Selection();
		List<Selection> selList= session.createQuery("from Selection").list();
		List<Selection> s2 =  new ArrayList<Selection>();
		for(Selection currentSelection: selList)
		{
			if(currentSelection.getIs_applied()==1 && currentSelection.getIs_select()==0 || currentSelection.getIs_select()==1)
			{
			
			 s2.add(currentSelection);
			}
		
		}
		return s2;
	}

	@Override
	public List<Selection> getSelectionselect()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Selection s1 = new Selection();
		List<Selection> selList= session.createQuery("from Selection").list();
		List<Selection> s2 =  new ArrayList<Selection>();
		for(Selection currentSelection: selList)
		{
			if(currentSelection.getIs_select()==1 && currentSelection.getIs_applied()==1)
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
