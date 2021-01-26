package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
								
			//start a transaction
			session.beginTransaction();
			
			int theId = 1;
			
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail: "+theInstructorDetail);
			
			System.out.println("associated instructor: "+theInstructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			//System.out.println("saved");
			
		}finally{
			//caso aconteça algum erro, a seção ficaria aberta 
			session.close();
			
			factory.close();
		}
		
		
	}

}
