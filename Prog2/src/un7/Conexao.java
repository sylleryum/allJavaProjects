package un7;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Properties;

public class Conexao {
	// Atributos da Classes
	private String Usuario, Senha, Servidor, DataBase;
	private Connection Con;
	private boolean Conectado;
	private ResultSet Dados;

	// Construtor da Classe
	public Conexao() {
		setSenha("");
		setUsuario("");
		setServidor("");
		setConectado(false);
		setCon(null);
		setDados(null);
		setDataBase("");
	}

	public Conexao(String SERV, String DB, String USU, String SENHA) {
		setSenha(SENHA);
		setUsuario(USU);
		setServidor(SERV);
		setDataBase(DB);
		setConectado(false);
		setCon(null);
		setDados(null);
	}

	// Modifcadores
	public void setCon(Connection con) {
		Con = con;
	}

	public void setConectado(boolean conectado) {
		Conectado = conectado;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public void setServidor(String servidor) {
		Servidor = servidor;
	}

	public void setDados(ResultSet dados) {
		Dados = dados;
	}

	public void setDataBase(String DB) {
		DataBase = DB;
	}

	// Recuperadores
	public String getUsuario() {
		return Usuario;
	}

	public String getSenha() {
		return Senha;
	}

	public boolean getConectado() {
		return Conectado;
	}

	public Connection getCon() {
		return Con;
	}

	public String getServidor() {
		return Servidor;
	}

	public ResultSet getDados() {
		return Dados;
	}

	public String getDataBase() {
		return DataBase;
	}

	public void Conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://" + getServidor() + ":3306" + "/" + getDataBase()+"?autoReconnect=true&useSSL=false";
			//System.out.println(URL);
			setCon(DriverManager.getConnection(URL, getUsuario(), getSenha()));
			setConectado(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conexão não foi realizada!", "", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
			setConectado(false);
			return;
		}
		JOptionPane.showMessageDialog(null, "Conexão realizada com Sucesso!", "", JOptionPane.WARNING_MESSAGE);
	}

	public void FecharConexao() {
		try {
			if (getConectado())
				getCon().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Conexão não foi fechada!", "", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void ExpressaoSQL(String Comando) {
		if (getConectado()) {
			try {
				Statement st = getCon().createStatement();
				if (Comando.toUpperCase().indexOf("SELECT") != -1)
					setDados(st.executeQuery(Comando));
				else {
					setDados(null);
					st.executeUpdate(Comando);
					if (Comando.toUpperCase().indexOf("UPDATE") != -1)
						JOptionPane.showMessageDialog(null, "Dados Atualizados!", "", JOptionPane.WARNING_MESSAGE);
					else if (Comando.toUpperCase().indexOf("DELETE") != -1)
						JOptionPane.showMessageDialog(null, "Dados Removidos!", "", JOptionPane.WARNING_MESSAGE);
					else if (Comando.toUpperCase().indexOf("INSERT") != -1)
						JOptionPane.showMessageDialog(null, "Dados Inseridos!", "", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "SQL Inválido!", "", JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(null, "Erro :" + sqle.getMessage(), "", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}