package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			//use the session object to save java object
			
			//create a student object
			Student tempStudent = new Student("sam", "smith", "sam@luv2code.com");
			Student tempStudent1 = new Student("sam1", "smith1", "sam1@luv2code.com");
			Student tempStudent2 = new Student("sam2", "smith2", "sam2@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
		}finally{
			factory.close();
		}
		
		
	}

}
