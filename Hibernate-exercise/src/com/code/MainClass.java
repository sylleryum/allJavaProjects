package com.code;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.classes.Employee;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				// .addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// Save objects
			// // Employee employee1 = new Employee("carlos", "smart", "lotuso");
			// Employee employee2 = new Employee("amandeus", "sart", "gartner");
			// Employee employee3 = new Employee("salvador", "smigh", "lotuso");
			// Employee employee4 = new Employee("carlos", "nolse", "gartner");
			//
			// session.beginTransaction();
			//
			// // session.save(employee1);
			// session.save(employee2);
			// session.save(employee3);
			// session.save(employee4);
			//
			// session.getTransaction().commit();

			// *********************************************
			// //get single objects
			// session.beginTransaction();
			//
			// Employee employeeR = session.get(Employee.class, 4);
			//
			// System.out.println(employeeR);
			//
			// session.getTransaction().commit();

			// *********************************************
			// get objects with queries

			 session.beginTransaction();
			 List<Employee> lEmployee = session.createQuery("from Employee where company='gartner'").getResultList();
			
			 for (Employee tempEmployee:lEmployee){
			 System.out.println("employees: "+tempEmployee);
			 }

			// *********************************************
			// update object

			// session.beginTransaction();
			// Employee employeeR = session.get(Employee.class, 4);
			// employeeR.setFirstName("salvadora");
			//
			// session.getTransaction().commit();

			// *********************************************
			// delete object

			// session.beginTransaction();
			// Employee employeeR = session.get(Employee.class, 3);
			// session.delete(employeeR);
			//
			// session.getTransaction().commit();

			// *********************************************
			// delete object with clause

			// session.beginTransaction();
			// session.createQuery("delete from Employee where
			// firstName='carlos'").executeUpdate();
			//
			// session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
