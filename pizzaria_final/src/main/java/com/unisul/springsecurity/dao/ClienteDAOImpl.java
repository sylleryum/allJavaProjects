
package com.unisul.springsecurity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unisul.springsecurity.Entity.Cliente;

@Component
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cliente> getClientes() {		
		return null;
	}

	@Override
	@Transactional
	public void saveCliente(Cliente theCCliente) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theCCliente);
	}

	@Override
	public Cliente getClienteById(String theCliente) {
		
		return null;
	}
	
	@Override
	@Transactional
	public Cliente getClienteByName(String userNome) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Cliente c where c.username= :username");
		query.setParameter("username", userNome);
		if (query.uniqueResult()==null) {
			System.out.println("não existe - ????????");
			return null;
		} else {
			Cliente cliente = (Cliente) query.uniqueResult();
			return cliente;
		}
	}
	
	@Override
	@Transactional
	public boolean verifyCliente(String username) {		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Cliente c where c.username= :username");
		query.setParameter("username", username);
		if (query.uniqueResult()==null) {
			System.out.println("não existe");
			return true;
		} else {
			System.out.println("já existe: "+query.uniqueResult());
			return false;
		}
		//resultCliente = currentSession.createQuery("from Cliente c where c.username='"+username+"'").getResultList();
		//System.out.println("resultado da busca por username: "+resultCliente);
		//System.out.println("nº resultado: "+num);
//		if (resultCliente.get(0).getId()>=0) {
//			System.out.println("usuario já existe no id"+resultCliente.get(0).getId());
//			return false;
//		}

	}

	@Override
	public void deleteCliente(int theId) {
		
	}

	

	

}
