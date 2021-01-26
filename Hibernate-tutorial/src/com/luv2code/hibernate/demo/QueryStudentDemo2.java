package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query object
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			//display object			
			displayObjects(theStudent);
			
			System.out.println("======with clause======");
			
			//query object with clause
			theStudent = session.createQuery("from Student s where s.lastName='smith'").getResultList();
			//display object			
			displayObjects(theStudent);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("saved");

		} finally {
			factory.close();
		}

	}

	private static void displayObjects(List<Student> theStudent) {
		for (Student forStudent : theStudent) {
			System.out.println(forStudent);
		}
	}

}
