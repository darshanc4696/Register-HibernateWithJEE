package com.tap.daoimpl;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tap.dao.StudentDAO;
import com.tap.entity.Student;

public class StudentDAOImpl implements StudentDAO 
{
	public Session openSession;

	public StudentDAOImpl()
	{
		openSession = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory().openSession();
	}

	@Override
	public int add(Student s) 
	{
		openSession.beginTransaction();
		openSession.persist(s);
		openSession.getTransaction().commit();
		return 1;
	}
	

}
