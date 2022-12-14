package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;
import com.base.spring.model.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, 4);
			session.delete(student);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
