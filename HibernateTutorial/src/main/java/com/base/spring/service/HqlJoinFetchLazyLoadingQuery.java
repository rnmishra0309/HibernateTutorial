package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;

public class HqlJoinFetchLazyLoadingQuery {

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
			Integer instructorId = 5;
			Query<Instructor> queryString = session.createQuery("SELECT i FROM Instructor i "
																+ "JOIN FETCH i.courses "
																+ " WHERE i.id=:instructorId",
																Instructor.class);
			queryString.setParameter("instructorId", instructorId);
			Instructor instructor = queryString.getSingleResult();
			System.out.println("Instructor: " + instructor.toString());
			session.getTransaction().commit();
			session.close();
			System.out.println("Courses: " + instructor.getCourses().toString());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null && factory != null) {
				session.close();
				factory.close();
			}
		}

	}

}
