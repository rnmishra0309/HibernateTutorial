package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;

public class AddOrUpdateInstructor {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			InstructorDetail instructorDetail = new InstructorDetail("Niharika Maths", "Tennis", 0);
			Instructor instructor = new Instructor("Niharika", "Singh", "Niharika.singh@gmail.com", instructorDetail, 0);
			session.beginTransaction();
			session.saveOrUpdate(instructor);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
}
