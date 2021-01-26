package un8_9;

import un7.Conexao;

public class Teste {
public static void main(String[] args) {
Conexao C = new Conexao("localhost", "livro", "sqluser", "sql123");
C.Conectar();
if (C.getConectado()){
Manipula_Projeto MP = new Manipula_Projeto(C);
//Insere dois Projetos
Projetos projeto = new Projetos();
MP.InsereDados(projeto);
MP.InsereDados(projeto);
//Remove o Projeto de Código 1
MP.RemoverDados(1);
//Lista os Projetos cadastrados
MP.ListarDados();
//Atualiza o projeto de descrição chamada TESTE
//MP.AtualizarDados("TESTE");
C.FecharConexao();
}
}
}