package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			Student myStudent = session.get(Student.class, studentId);									
			
			//delete
			//delete single object
			session.delete(myStudent);
			
			//delete multiple objects
			//session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();			
			
			
		}finally{
			factory.close();
		}
		
		
	}

}
