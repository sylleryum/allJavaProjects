package com.unisul.springsecurity.dao;

import java.util.List;
import com.unisul.springsecurity.Entity.Pedido;

public interface PedidoDAO {

	public List<Pedido> getPedidos();
	
	public List<Pedido> getPedidosById(int id);
	
	public List<Pedido> getPedidosByUsername(String username);

	public int savePedido(Pedido thePedido);
	
	public void updatePedidoStatus(String update, int id);

	public Pedido getPedidoById(int id);

	public void deletePedido(int theId);
	
}
