package com.unisul.springsecurity.Entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//TODO mapear relacao com cliente
	@Column(name="cliente")
	private int cliente;
	
	@NotNull(message = "Por favor, selecione o tamanho")
	@Column(name="tamanho")
	private String tamanho;
	
	@NotNull(message = "Por favor, selecione a massa")
	@Column(name="massa")
	private String massa;
	
	@NotNull(message = "Por favor, selecione a borda")
	@Column(name="borda")
	private String borda;
	
	@Min(value=1, message="Por favor, selecione a quantidade de sabores")
	@Column(name="dividida")
	private int dividida;
	
	@Column(name="sabor1")
	private String sabor1;
	
	@Column(name="sabor2")
	private String sabor2;
	
	@Column(name="sabor3")
	private String sabor3;
	
	@Column(name="adicional")
	
	private String adicional;
	
	@Column(name="personalizar")
	@Size(max=195, message="Caracteres excedentes, favor revisar")
	private String personalizar;
	
	@Column(name="bebida")
	private String bebida;
	
	@Column(name="oEndereco")
	@Size(max=240, message="Caracteres excedentes, favor revisar")
	private String oEndereco;
	
	@Column(name="preco")
	private double preco;
	
	@Column(name="status")
	private String status;
	
	//endereco para pegar o selecionado pelo cliente
	@Transient
	private String selectedAddress;

	public String getSelectedAddress() {
		return selectedAddress;
	}

	public void setSelectedAddress(String selectedAddress) {
		this.selectedAddress = selectedAddress;
	}

	public Pedido() {
		
//		countryList = new LinkedHashMap<>();		
//		countryList.put("BR", "Brazil");
//		countryList.put("FR", "France");
//		countryList.put("DE", "Germany");
//		countryList.put("US", "United States");
	}
	
	public Pedido(int id, int cliente, String tamanho, String massa, String borda, int dividida, String sabor1,
			String sabor2, String sabor3, String adicional, String personalizar, String bebida, String oEndereco,
			double preco, String status) {
		this.id = id;
		this.cliente = cliente;
		this.tamanho = tamanho;
		this.massa = massa;
		this.borda = borda;
		this.dividida = dividida;
		this.sabor1 = sabor1;
		this.sabor2 = sabor2;
		this.sabor3 = sabor3;
		this.adicional = adicional;
		this.personalizar = personalizar;
		this.bebida = bebida;
		this.oEndereco = oEndereco;
		this.preco = preco;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getBorda() {
		return borda;
	}

	public void setBorda(String borda) {
		this.borda = borda;
	}

	public int getDividida() {
		return dividida;
	}

	public void setDividida(int dividida) {
		this.dividida = dividida;
	}

	public String getSabor1() {
		return sabor1;
	}

	public void setSabor1(String sabor1) {
		this.sabor1 = sabor1;
	}

	public String getSabor2() {
		return sabor2;
	}

	public void setSabor2(String sabor2) {
		this.sabor2 = sabor2;
	}

	public String getSabor3() {
		return sabor3;
	}

	public void setSabor3(String sabor3) {
		this.sabor3 = sabor3;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public String getPersonalizar() {
		return personalizar;
	}

	public void setPersonalizar(String personalizar) {
		this.personalizar = personalizar;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	public String getoEndereco() {
		return oEndereco;
	}

	public void setoEndereco(String oEndereco) {
		this.oEndereco = oEndereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", tamanho=" + tamanho + ", massa=" + massa + ", borda="
				+ borda + ", dividida=" + dividida + ", sabor1=" + sabor1 + ", sabor2=" + sabor2 + ", sabor3=" + sabor3
				+ ", adicional=" + adicional + ", personalizar=" + personalizar + ", bebida=" + bebida + ", oEndereco="
				+ oEndereco + ", preco=" + preco + ", status=" + status + ", selectedAddress=" + selectedAddress + "]";
	}


	
	

}
