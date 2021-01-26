package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMary {

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
			
			int theId = 1;
			
			Student tempStudent = session.get(Student.class, theId);
			
			Course tempCourse = new Course("novo curso 10");
			Course tempCourse2 = new Course("novo curso 11");
			Course tempCourse3 = new Course("novo curso 12");
			
			tempStudent.addCourse(tempCourse);
			tempStudent.addCourse(tempCourse2);
			tempStudent.addCourse(tempCourse3);
			
//			tempCourse.addStudent(tempStudent);
//			tempCourse2.addStudent(tempStudent);
//			tempCourse3.addStudent(tempStudent);
			
			System.out.println(tempStudent.getCourses());
			
			session.save(tempStudent);
			
//			session.save(tempCourse);
//			session.save(tempCourse2);
//			session.save(tempCourse3);

			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("saved");
			
		}finally{
			session.close();
			factory.close();
		}
		
		
	}

}
