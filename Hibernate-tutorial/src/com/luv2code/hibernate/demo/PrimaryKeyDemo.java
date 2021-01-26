package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// use the session object to save java object

			// create 3 student object
			Student tempStudent1 = new Student("samuel", "smith", "samuel@luv2code.com");
			Student tempStudent2 = new Student("samara", "smant", "samara@luv2code.com");
			Student tempStudent3 = new Student("samsara", "smigle", "samsara@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("saved");

		} finally {
			factory.close();
		}
	}

}
