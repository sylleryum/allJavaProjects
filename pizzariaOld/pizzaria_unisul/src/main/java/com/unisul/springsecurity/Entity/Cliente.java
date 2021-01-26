package com.unisul.springsecurity.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cliente {

	private int id;
	
	@NotNull(message = "Campo necessário")
	private String username;
	
	@NotNull(message = "Campo necessário")
	private String password;
	
	@NotNull(message = "Campo necessário")
	private String nome;
	
	@NotNull(message = "Campo necessário")
	private String sobrenome;
	
	@NotNull(message = "Campo necessário")
	@Size(min = 7, message = "Favor verificar o telefone")
	private int tel;
	
	@NotNull(message = "Campo necessário")
	private String endereco;
	
	@NotNull(message = "Campo necessário")
	private String email;
	
	private int enabled;

	public Cliente() {

	}

	public Cliente(String username, String password, String nome, String sobrenome, int tel, String endereco,
			String email) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tel = tel;
		this.endereco = endereco;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
