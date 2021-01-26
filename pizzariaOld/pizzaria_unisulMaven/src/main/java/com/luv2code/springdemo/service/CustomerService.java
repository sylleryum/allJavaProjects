package com.luv2code.springdemo.service;

import java.util.List;

import com.unisul.springsecurity.Entity.Cliente;


public interface CustomerService {

	public List<Cliente> getClientes();

	public void saveCliente(Cliente theCliente);

	public Cliente getCliente(int theId);

	public void deleteCliente(int theId);
	
}
