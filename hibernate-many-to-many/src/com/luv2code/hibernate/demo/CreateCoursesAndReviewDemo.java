package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			
					
			//start a transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman");
			Course tempCourse1 = new Course("megaman");
			
			tempCourse.addReview(new Review("great course"));
			tempCourse.addReview(new Review("good course"));
			tempCourse.addReview(new Review("meh course"));
			
			tempCourse1.addReview(new Review("great course too"));
			tempCourse1.addReview(new Review("good course too"));
			
			System.out.println("saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			session.save(tempCourse1);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
		}finally{
			session.close();
			factory.close();
		}
		
		
	}

}
