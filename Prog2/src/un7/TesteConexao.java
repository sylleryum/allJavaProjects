package un7;

public class TesteConexao {
	public static void main(String args[]) {
		Conexao C = new Conexao("localhost", "livro", "sqluser", "sql123");
		C.Conectar();
		C.FecharConexao();
	}
}