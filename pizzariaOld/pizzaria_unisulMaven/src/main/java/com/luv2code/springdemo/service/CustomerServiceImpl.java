package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.unisul.springsecurity.Entity.Cliente;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject cliente dao
	@Autowired
	private CustomerDAO clienteDAO;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		return clienteDAO.getClientes();
	}

	@Override
	@Transactional
	public void saveCliente(Cliente theCliente) {

		clienteDAO.saveCliente(theCliente);
	}

	@Override
	@Transactional
	public Cliente getCliente(int theId) {
		
		return clienteDAO.getCliente(theId);
	}

	@Override
	@Transactional
	public void deleteCliente(int theId) {
		
		clienteDAO.deleteCliente(theId);
	}
}





