package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		System.out.println("test 1 CustomerDAOImpl ");
		Session session = sessionFactory.getCurrentSession();
		
		//List<Customer> tempCustomer = session.createQuery("from customer").getResultList();		
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
		
		List<Customer> customersList = theQuery.getResultList();
		System.out.println("CustomerDAOImpl" +customersList);
		return customersList;
	}
	
	public boolean saveCustomer(Customer theCustomer){
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(theCustomer);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

}
