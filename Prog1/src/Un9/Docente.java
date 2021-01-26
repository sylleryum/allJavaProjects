package Un9;
public class Docente extends Funcionario{
	private int nha;
	private String titulacao;
	
	public Docente(){
	super( );
	nha=0;
	titulacao="";
	}
	
	public void setSalario(double dsalario){
		if (titulacao.equalsIgnoreCase("Especialista"))
			super.setSalario(dsalario+(nha*15));
		else if (titulacao.equalsIgnoreCase("Mestre"))
			super.setSalario(dsalario+(nha*20));
		else
			super.setSalario(dsalario+(nha*30));
		
	}
	
	
	public void setNha(int inha){
	nha=inha;
	}
	public int getNha(){
	return nha;
	}
	public void setTitulacao(String stitu){
	titulacao=stitu;
	}
	public String getTitulacao(){
	return titulacao;
	}
}