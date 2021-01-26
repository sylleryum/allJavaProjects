public class adClasse{
	private String nome, nomeClube;
	private int gols;
	
	//construtor
	public adClasse( ){
		nome="";
		nomeClube="";
		gols=0;
	}
	//sobrecarga
	public adClasse(String nnome, String nnomeClube, int nGols){ 
	nome = nnome;
	nomeClube = nnomeClube;
	gols = nGols;
	}
	
	public void setNome(String nnome){
	nome=nnome;
	}
	
	public void setNomeClube(String nNomeClube){
	nomeClube=nNomeClube;
	}
	
	public void setGols(int nGols){
	gols=nGols;
	}
	
	//get
	public String getNome(){
	return nome;
	}
	
	public String getNomeClube(){
	return nomeClube;
	}
	
	public int getGols(){
	return gols;
	}
}