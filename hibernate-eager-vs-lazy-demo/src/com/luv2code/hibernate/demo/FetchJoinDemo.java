package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {
	
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			//option 1: call the get from DB prior to closing connection
			
			//option 2: hibernate query with HQL:		
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "JOIN FETCH i.courses "
														+ "where i.id=:theInstructorId", Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get results
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("Instructor: "+tempInstructor);
			
			//courses
			//System.out.println("\n\n Courses: "+tempInstructor.getCourses()+"\n");

			// commit transaction
			session.getTransaction().commit();

			session.close();
			
			System.out.println("After close Courses: "+tempInstructor.getCourses()+"\n");

		} finally {
			session.close();
			
			factory.close();
		}

	}
}
