package com.unisul.springsecurity.DAO;

import java.util.List;

import javax.transaction.Transactional;
import com.unisul.springsecurity.Entity.Cliente;
import com.unisul.springsecurity.config.DemoAppConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;



public class ClienteDAOImpl implements ClienteDAO{

	//@Autowired
	//private SessionFactory sessionFactory;

	@Override
	public List<Cliente> getClientes() {
		
		return null;
	}

	@Override
	//@Transactional
	public boolean saveCliente(Cliente theCliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(theCliente);
			session.getTransaction().commit();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}

	}


	
	
}
