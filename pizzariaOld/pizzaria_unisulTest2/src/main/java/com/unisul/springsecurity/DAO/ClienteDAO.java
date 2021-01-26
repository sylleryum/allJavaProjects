package com.unisul.springsecurity.DAO;

import java.util.List;

import com.unisul.springsecurity.Entity.Cliente;




public interface ClienteDAO {
	public List<Cliente> getClientes();
	public boolean saveCliente(Cliente theCliente);
}
