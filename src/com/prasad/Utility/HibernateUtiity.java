package com.prasad.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtiity {
	public static Session getSession() {
	Configuration config=new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sf=config.buildSessionFactory();
	Session session=sf.openSession();
	return session;
	
	}

}
