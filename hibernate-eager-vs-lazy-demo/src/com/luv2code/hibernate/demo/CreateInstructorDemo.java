package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			//create the objects
			Instructor tempInstructor = new Instructor("Chad2", "Darby2", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube2", "luv 2 code!!!");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
					
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//will also save the details object
			//because of the cascadetype.all
			System.out.println("saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
		}finally{
			factory.close();
		}
		
		
	}

}
