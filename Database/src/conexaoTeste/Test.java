package conexaoTeste;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Test {

	public static void main(String[] args) {
		Conexao C = new Conexao("localhost", "ConnectionDB", "sqluser", "sql123");
		C.Conectar();
		try {
			Statement stat = C.getCon().createStatement();
//			stat.execute("CREATE TABLE contacts (name VARCHAR(30), phone INT, email VARCHAR(30))");
			stat.execute("INSERT INTO contacts (name, phone, email) values ('nome2', 222, 'email2')");
			
			stat.close();
			C.getCon().close();
		} catch (SQLException e) {
			System.out.println("connection error");
			e.printStackTrace();
		}
	}
	
}
