package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
						
					
			//start a transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman");

			session.save(tempCourse);
			
			Student tempStudent = new Student("john", "doe", "john@email.com");
			Student tempStudent1 = new Student("mary", "kat", "mary@email.com");
			
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			
			session.save(tempStudent);
			session.save(tempStudent1);
			

			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
		}finally{
			session.close();
			factory.close();
		}
		
		
	}

}
