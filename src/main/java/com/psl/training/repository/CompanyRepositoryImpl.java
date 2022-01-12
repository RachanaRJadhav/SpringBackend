package com.psl.training.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psl.training.model.Company;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
	

	@Autowired
	SessionFactory sessionFactory;

	public List<Company> getAllCompanies() {

		Session session=sessionFactory.openSession();
		List<Company> stdList= session.createQuery("from Company").list();
		System.out.println(stdList.size());
		session.close();
		return stdList;
	}

	public Company getCompanyById(int id) {
		
		Session session=sessionFactory.openSession();
		return session.get(Company.class, id);
		
	}
	@Override
	public void  addCompany(Company comp) {
		
// Programmatic way of managing transactions

	Session session=	sessionFactory.openSession();
	session.beginTransaction();
	session.save(comp);
	session.getTransaction().commit();


		
	}

	@Override
	public void deleteCompany(int id) {
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
