package com.unisul.springsecurity.dao;

import java.util.List;

import com.unisul.springsecurity.Entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes();

	public void saveCliente(Cliente theCCliente);

	public Cliente getClienteById(String theCliente);
	
	public Cliente getClienteByName(String userNome);
	
	public boolean verifyCliente(String username);

	public void deleteCliente(int theId);
	
}
