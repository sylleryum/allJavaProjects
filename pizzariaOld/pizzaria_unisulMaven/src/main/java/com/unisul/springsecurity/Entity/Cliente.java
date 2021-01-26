package com.unisul.springsecurity.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	@NotNull(message = "Campo necess�rio")
	@Size(min=2, message="Campo n�o pode estar em branco")
	private String username;
	
	@Column(name="password")
	@NotNull(message = "Campo necess�rio")
	private String password;
	
	@Column(name="nome")
	@NotNull(message = "Campo necess�rio")
	private String nome;
	
	@Column(name="sobrenome")
	@NotNull(message = "Campo necess�rio")
	private String sobrenome;
	
	@Column(name="tel")
	@NotNull(message = "Campo necess�rio")
	//@Size(min=8, message = "Por favor, verifique o numero")
	private Integer tel;
	
	@Column(name="endereco")
	@NotNull(message = "Campo necess�rio")
	private String endereco;
	
	@Column(name="email")
	@NotNull(message = "Campo necess�rio")
	private String email;
	
	@Column(name="enabled")
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

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
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
