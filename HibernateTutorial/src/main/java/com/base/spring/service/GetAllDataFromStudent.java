package com.base.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Student;

public class GetAllDataFromStudent {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			List<Student> allStudents = new ArrayList<Student>();
			session.beginTransaction();
			allStudents = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
			for(Student student: allStudents) System.out.println(student);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
}
