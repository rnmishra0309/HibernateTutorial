package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Student;

public class FirstCommitStudent {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			Student student = new Student("Ar", "Mohanty", "ar@gmail.com", 1);
			session.beginTransaction();
			session.saveOrUpdate(student);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
