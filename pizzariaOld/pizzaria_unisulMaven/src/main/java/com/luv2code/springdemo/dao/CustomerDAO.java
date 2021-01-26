package com.luv2code.springdemo.dao;

import java.util.List;

import com.unisul.springsecurity.Entity.Cliente;

public interface CustomerDAO {

	public List<Cliente> getClientes();

	public void saveCliente(Cliente theCCliente);

	public Cliente getCliente(int theId);

	public void deleteCliente(int theId);
	
}
