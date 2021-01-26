package AD2Q4;
public class Sintoma{
	private String nome;
	private int duracao;
	
	//construtor
	public Sintoma( ){
		nome="";
		duracao=0;
	}
	//sobrecarga
	public Sintoma(String nnome, int nduracao){ 
	nome = nnome;
	duracao = nduracao;
	}
	
	public void setNome(String nnome){
	nome=nnome;
	}
	
	public void setduracao(int nduracao){
	duracao=nduracao;
	}
	
	//get
	public String getNome(){
	return nome;
	}
	
	public int getduracao(){
	return duracao;
	}
}