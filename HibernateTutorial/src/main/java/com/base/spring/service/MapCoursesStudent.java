package com.base.spring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.spring.model.Courses;
import com.base.spring.model.Instructor;
import com.base.spring.model.InstructorDetail;
import com.base.spring.model.Student;

public class MapCoursesStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .addAnnotatedClass(Courses.class)
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			// get the courses
			/*
			 * Courses science = session.get(Courses.class, 4); Courses math =
			 * session.get(Courses.class, 6); Courses socialStudies =
			 * session.get(Courses.class, 7); Courses music = session.get(Courses.class, 8);
			 * 
			 * // get the students Student first = session.get(Student.class, 1); Student
			 * second = session.get(Student.class, 2); Student third =
			 * session.get(Student.class, 3);
			 * 
			 * List<Student> scienceStudents = new ArrayList<Student>();
			 * scienceStudents.add(first); scienceStudents.add(second);
			 * science.addStudents(scienceStudents); session.saveOrUpdate(science);
			 * session.saveOrUpdate(first); session.saveOrUpdate(second);
			 * session.saveOrUpdate(third);
			 */
			
			/*
			 * List<Student> mathsStudents = new ArrayList<Student>();
			 * mathsStudents.add(first); mathsStudents.add(second);
			 * mathsStudents.add(third); math.addStudents(mathsStudents);
			 * 
			 * List<Courses> thirdStudentCourses = new ArrayList<Courses>();
			 * thirdStudentCourses.add(socialStudies); thirdStudentCourses.add(music);
			 * third.addCourses(thirdStudentCourses);
			 * 
			 * List<Courses> secondStudentCourses = new ArrayList<Courses>();
			 * secondStudentCourses.add(socialStudies);
			 * second.addCourses(secondStudentCourses);
			 */
			
			Courses gameCourse = new Courses("BadmintonGames", 0);
			Student fourth = new Student("Rajesh", "Ghosal", "r.g@g.com", 0);
			session.saveOrUpdate(gameCourse);
			session.saveOrUpdate(fourth);
			gameCourse.addStudent(fourth);
			
			
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
