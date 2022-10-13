package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;

public class CreateCourses {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Courses courseMusic = new Courses("Music", 0);
			Courses courseSS = new Courses("Social Studies", 0);
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 5);
			instructor.add(courseSS);
			instructor.add(courseMusic);
			session.saveOrUpdate(courseSS);
			session.saveOrUpdate(courseMusic);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
