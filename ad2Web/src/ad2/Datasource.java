package ad2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Datasource {
	public static final String DB_NAME = "pessoa";
	public static final String TABLE_PESSOA = "pessoa";
	public static final String COL_PESSOAID = "pessoaID";
	public static final String COL_NOME = "nome";
	public static final String COL_IDADE = "idade";
	public static final String COL_DATANASC = "dataNascimento";
	public static final String COL_CIDADE = "cidade";
	public static final String COL_ESTADO = "estadoCivil";

	// private String nome = "tio patinhas";
	private boolean conectado;
	private int idade = 11;
	private String cidade = "cb";
	// data = 'ano-mes-dia';
	// private String dataNascimento = "'2007-10-25'";
	private String dataNascimento = "20/04/2012";
	private String estadoCivil = "solteiro";

	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME
			+ "?autoReconnect=true&useSSL=false";

	private Connection conn;

	public boolean open() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// try {
			// Class.forName("com.mysql.jdbc.Driver");
			// } catch (ClassNotFoundException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			conn = DriverManager.getConnection(CONNECTION_STRING, "sqluser", "sql123");
			System.out.println("okk");
			return conectado = true;
		} catch (SQLException e) {
			System.out.println("Erro ao conectarse : " + e.getMessage());
			return conectado = false;
		}
	}

	public boolean getConexao() {
		return conectado;
	}

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectarse : " + e.getMessage());
		}
	}

	public String singleQuote(String palavra) {
		return "'" + palavra + "'";

	}

	public String dateFormat(String date) {
		// String test =
		// "'"+date.substring(6)+"-"+date.substring(3,5)+"-"+date.substring(0,2)+"'";
		// System.out.println(test);
		return "'" + date.substring(6) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2) + "'";
	}

	public boolean saveToDb(String nome, int idade, String dataNascimento, String cidade, String estadoCivil) {
		try (Statement stat = conn.createStatement();) {

			stat.execute("INSERT INTO " + TABLE_PESSOA + "(" + COL_NOME + "," + COL_IDADE + "," + COL_DATANASC + ","
					+ COL_CIDADE + "," + COL_ESTADO + ") VALUES ('" + nome + "', " + idade + ","
					+ dateFormat(dataNascimento) + ",'" + cidade + "', '" + estadoCivil + "')");
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro no comando: " + e.getMessage());
			return false;
		}
	}

	public boolean updateToDb(String nome, int idade, String dataNascimento, String cidade, String estadoCivil, int id) {
		try (Statement stat = conn.createStatement();) {

			// stat.execute("INSERT INTO " + TABLE_PESSOA +
			// "("+COL_NOME+","+COL_IDADE+","+COL_DATANASC+","+COL_CIDADE+","+COL_ESTADO+
			// ") VALUES ('"+nome+"',
			// "+idade+","+dateFormat(dataNascimento)+",'"+cidade+"',
			// '"+estadoCivil+"')" );

			stat.execute("update " + TABLE_PESSOA + " set " + COL_NOME + " = " + singleQuote(nome) + ", " + COL_IDADE
					+ " = " + idade + ", " + COL_DATANASC + "= " + dateFormat(dataNascimento) + "," + COL_CIDADE + "= "
					+ singleQuote(cidade) + ", " + COL_ESTADO + "= " + singleQuote(estadoCivil) + " where "
					+ COL_PESSOAID + "= " + id);
			return true;
			// ") VALUES ('"+nome+"',
			// "+idade+","+dateFormat(dataNascimento)+",'"+cidade+"',
			// '"+estadoCivil+"')" );
			// update pessoa set nome='tester', idade=4,
			// dataNascimento='2000-01-01', cidade='sar', estadoCivil='viuvo'
			// where pessoaID=5;

		} catch (SQLException e) {
			System.out.println("erro no comando: " + e.getMessage());
			return false;
		}
	}

	public Pessoa alterar(int id) {
		try (Statement stat = conn.createStatement();
				ResultSet results = stat.executeQuery("SELECT * FROM pessoa where pessoaID= " + id);) {
			// Statement stat = conn.createStatement();
			// ResultSet results = stat.executeQuery("SELECT * FROM pessoa where
			// pessoaID= "+ id);
			// int resultado = -1;
			Pessoa bPessoa = new Pessoa(-1);
			if (results.next()) {
				// resultado = results.getInt(COL_PESSOAID);
				bPessoa.setPessoaID(results.getInt(COL_PESSOAID));
				bPessoa.setNome(results.getString(COL_NOME));
				bPessoa.setIdade(results.getInt(COL_IDADE));
				bPessoa.setDataNasc(results.getString(COL_DATANASC));
				bPessoa.setCidade(results.getString(COL_CIDADE));
				bPessoa.setEstado(results.getString(COL_ESTADO));
				// pessoaList.add(pessoa);
				return bPessoa;
			} else {
				// JOptionPane.showMessageDialog(null, "Nada encontrado");
				System.out.println("nada encontrado");
				return bPessoa;
			}
			// System.out.println("resultado " +resultado);
			// System.out.println("!");

		} catch (SQLException e) {
			System.out.println("Nada encontrado/erro: " + e.getMessage());
			Pessoa nPessoa = new Pessoa(-1);
			// System.out.println("55" + nPessoa.getPessoaID());
			return nPessoa;
		}
	}

	public boolean excluir(int id) {
		// Statement stat;
		// ResultSet results ;
		try (Statement stat = conn.createStatement();

				ResultSet results = stat.executeQuery("SELECT * FROM pessoa where pessoaID= " + id)) {

			// stat = conn.createStatement();
			// results = stat.executeQuery("SELECT * FROM pessoa where pessoaID=
			// "+ id);
			// int resultado = -1;
			Pessoa ePessoa = new Pessoa(-2);
			if (results.next()) {
				// resultado = results.getInt(COL_PESSOAID);
				// System.out.println("!!!!!");
				ePessoa.setPessoaID(results.getInt(COL_PESSOAID));
				ePessoa.setNome(results.getString(COL_NOME));
				ePessoa.setIdade(results.getInt(COL_IDADE));
				ePessoa.setDataNasc(results.getString(COL_DATANASC));
				ePessoa.setCidade(results.getString(COL_CIDADE));
				ePessoa.setEstado(results.getString(COL_ESTADO));
								
				stat.execute("delete from " + TABLE_PESSOA + " where " + COL_PESSOAID + "= " + id);
				// delete from pessoa where pessoaID=15;
				System.out.println("Pessoa de ID: " + id + " excluida com sucesso!");
				return true;

			} else {
				System.out.println("Nada encontrado");				
				return false;
			}
			// System.out.println("resultado " +resultado);
			// System.out.println("!");

		} catch (SQLException e) {
			// System.out.println("Nada encontrado/erro: "+ e.getMessage());
			// Pessoa nPessoa = new Pessoa(-1);
			// System.out.println("55"+nPessoa.getPessoaID());
			System.out.println("?");
			return false;
		}
	}

	public List<Pessoa> returnPessoa() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("select * from " + TABLE_PESSOA);
			List<Pessoa> pessoaList = new ArrayList<>();
			while (result.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setPessoaID(result.getInt(COL_PESSOAID));
				pessoa.setNome(result.getString(COL_NOME));
				pessoa.setIdade(result.getInt(COL_IDADE));
				pessoa.setDataNasc(result.getString(COL_DATANASC));
				pessoa.setCidade(result.getString(COL_CIDADE));
				pessoa.setEstado(result.getString(COL_ESTADO));
				pessoaList.add(pessoa);
			}

			return pessoaList;

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}

	}
}
