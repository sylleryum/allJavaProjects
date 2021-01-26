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
	//TODO tamanho campos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	@NotNull(message = "Campo necessário")
	@Size(min=2, message="Campo não pode estar em branco")
	@Size(max=40, message="Caracteres excedentes, favor revisar")
	private String username;
	
	@Column(name="password")
	@NotNull(message = "Campo necessário")
	@Size(max=40, message="Caracteres excedentes, favor revisar")
	private String password;
	
	@Column(name="nome")
	@NotNull(message = "Campo necessário")
	@Size(max=40, message="Caracteres excedentes, favor revisar")
	private String nome;
	
	@Column(name="sobrenome")
	@NotNull(message = "Campo necessário")
	@Size(max=40, message="Caracteres excedentes, favor revisar")
	private String sobrenome;
	
	@Column(name="tel")
	@NotNull(message = "Campo necessário")
	//@Size(min=8, message = "Por favor, verifique o numero")
	private Integer tel;
	
	@Column(name="endereco")
	@NotNull(message = "Campo necessário")
	@Size(max=240, message="Caracteres excedentes, favor revisar")
	private String endereco;
	
	@Column(name="email")
	@NotNull(message = "Campo necessário")
	@Size(max=40, message="Caracteres excedentes, favor revisar")
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
		this.enabled = 1;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", tel=" + tel + ", endereco=" + endereco + ", email=" + email
				+ ", enabled=" + enabled + "]";
	}
	
	
}
