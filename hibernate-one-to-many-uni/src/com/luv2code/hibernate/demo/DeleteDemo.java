package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			//get instructor by primary key/id
			
			int theId=2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//delete
			if (tempInstructor != null){
				System.out.println("deleting: "+tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			
			//commit transaction
			session.getTransaction().commit();
			//System.out.println("saved");
			
		}finally{
			factory.close();
		}
		
		
	}

}
