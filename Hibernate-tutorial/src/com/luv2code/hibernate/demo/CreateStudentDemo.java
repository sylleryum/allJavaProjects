package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Danil", "mail", "dan@luv2code.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
			//ID:
			System.out.println("PK: "+tempStudent.getId());
			
			////Retrieve saved object
			
			//get new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve object
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("object retrieved: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("finished");
			
		}finally{
			factory.close();
		}
		
		
	}

}
