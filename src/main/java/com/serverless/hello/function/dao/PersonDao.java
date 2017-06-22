package com.serverless.hello.function.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.serverless.hello.function.modal.Person;


public class PersonDao  implements IPerson{
//	public static final Logger logger =Logger.getLogger("PersonDao.class");
	private SessionFactory sessionFactory;
	
	public void  setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	@Override
	public  void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Saving daatnin db");
		session.persist(p);
		tx.commit();
		session.close();
	}

	

}
