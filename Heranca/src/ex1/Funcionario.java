package ex1;
abstract class Funcionario {
	protected String nome; 
	protected int nMat;
	//construtor
	public Funcionario() {
		this.nome = "";
		this.nMat = 0;
	}
	//overload
	public Funcionario(String nome, int nMat) {
		this.nome = nome;
		this.nMat = nMat;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setnMat(int nMat){
		this.nMat = nMat;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNmat(){
		return nMat;
	}
}
