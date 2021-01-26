package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {
	
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Instructor: "+tempInstructor);
			
			//courses
			//System.out.println("\n\n Courses: "+tempInstructor.getCourses()+"\n");

			// commit transaction
			session.getTransaction().commit();

			session.close();
			
			System.out.println("Break Courses: "+tempInstructor.getCourses()+"\n");

		} finally {
			session.close();
			
			factory.close();
		}

	}
}
