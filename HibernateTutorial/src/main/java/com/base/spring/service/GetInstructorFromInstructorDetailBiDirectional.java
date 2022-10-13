package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;

public class GetInstructorFromInstructorDetailBiDirectional {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			session.getTransaction().commit();
			Instructor instructor = instructorDetail.getInstructor();
			System.out.println(instructorDetail);
			System.out.println(instructor);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close(); // handles the connection leaks issues.
			factory.close();
		}
	}
	
}
