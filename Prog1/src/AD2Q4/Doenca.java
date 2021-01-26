package AD2Q4;
public class Doenca{
	private String nome;
	private Sintoma sintoma;
	
	//construtor
	public Doenca( ){
		nome="";
		sintoma=null;
	}
	
	public void setNome(String nnome){
	nome=nnome;
	}
	
	public void setSintoma(Sintoma nSintoma){
	sintoma=nSintoma;
	}
	
	//get
	public String getNome(){
	return nome;
	}
	
	public Sintoma getSintoma(){
	return sintoma;
	}
}