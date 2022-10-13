package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;

public class DeleteInstructor {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 3);
			session.delete(instructor);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
}
