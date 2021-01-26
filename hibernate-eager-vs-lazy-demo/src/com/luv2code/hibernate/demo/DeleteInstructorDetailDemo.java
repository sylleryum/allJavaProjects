package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			int theId=3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//delete
			if (tempInstructorDetail != null){
				System.out.println("deleting: "+tempInstructorDetail);
				
				session.delete(tempInstructorDetail);
			}
			
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
