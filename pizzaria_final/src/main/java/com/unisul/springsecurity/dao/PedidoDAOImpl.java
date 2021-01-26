package com.unisul.springsecurity.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unisul.springsecurity.Entity.Cliente;
import com.unisul.springsecurity.Entity.Pedido;

@Component
public class PedidoDAOImpl implements PedidoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
    ClienteDAO dao;
	
	@Override
	@Transactional
	public List<Pedido> getPedidos() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Pedido> pedidos = currentSession.createQuery("from Pedido order by id desc").getResultList();
				
		return pedidos;
	}
	
	@Override
	@Transactional
	public List<Pedido> getPedidosById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Pedido> pedidos = currentSession.createQuery("from Pedido where cliente = "+id+" order by id desc").getResultList();
				
		return pedidos;
	}
	
	@Override
	@Transactional
	public List<Pedido> getPedidosByUsername(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Cliente cliente = dao.getClienteByName(username);
		List<Pedido> pedidos = currentSession.createQuery("from Pedido where cliente = "+cliente.getId()+" order by id desc").getResultList();
				
		return pedidos;
	}

	@Override
	@Transactional
	public int savePedido(Pedido thePedido) {		
		Session currentSession = sessionFactory.getCurrentSession();
			
		return (int) currentSession.save(thePedido); 
	}
	
	@Override
	@Transactional
	public void updatePedidoStatus(String update, int id) {
		System.out.println("status: "+update);
		Session currentSession = sessionFactory.getCurrentSession();
		Pedido pedido = (Pedido) currentSession.get(Pedido.class, id);
		pedido.setStatus(update);
		System.out.println("00000 " +pedido.getStatus());
		//currentSession.update(currentSession.get("Pedido", id));
	}

	@Override
	@Transactional
	public Pedido getPedidoById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Pedido pedido = currentSession.get(Pedido.class, id);
		
		return pedido;
	}

	@Override
	public void deletePedido(int theId) {
		

	}

	

}
