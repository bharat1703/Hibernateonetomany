package com.prasad.DaoImpl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.prasad.Entity.EmployeeEntity;
public class EmployeeDaoImpl {

	public void saveemp(EmployeeEntity empen) {
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			//business logic started
		session.save(empen);
			//business logic ended
			tx.commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}	
		
		
		
	}

	public EmployeeEntity getdetails(String fName) {
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=null;
		EmployeeEntity employeeresult=null;
		try{
			tx=session.beginTransaction();
			Criteria criteria=session.createCriteria(EmployeeEntity.class);
			criteria.add(Restrictions.eq("fName", fName));
			List<EmployeeEntity> criobj=criteria.list();
			for (EmployeeEntity obj : criobj) {
			
				if(obj.getfName().equalsIgnoreCase(fName)) {
					employeeresult=obj;
				}
			}
			tx.commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			if(tx.getStatus()!=null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}	
		return employeeresult;
	
		
		
	}

	public boolean updateemp(EmployeeEntity empobj) {
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=null;
		boolean recordUpdated=false; 
		try {	
		tx=session.beginTransaction();
			session.saveOrUpdate(empobj);
			tx.commit();
			recordUpdated=true;
		}catch (HibernateException he) {
			if (tx.getStatus() != null) {
				tx.rollback();
				recordUpdated = false;
			}
		} finally {
			session.close();
		}
		return recordUpdated;
	}

	public boolean deleteemp(EmployeeEntity empobj) {
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=null;
		boolean recordUpdated=false; 
		try {	
		tx=session.beginTransaction();
			session.delete(empobj);
			tx.commit();
			recordUpdated=true;
		}catch (HibernateException he) {
			if (tx.getStatus() != null) {
				tx.rollback();
				recordUpdated = false;
			}
		} finally {
			session.close();
		}
		return true;
	}

	
}
