public class Funcionario{
	private String nome, endereco;
	private double salario;
	
	public Funcionario( ){
		nome="";
		endereco="";
		salario=0;
	}
	
	public Funcionario(String nnome, String nendereco, double nsalario){
		nome=nnome;
		endereco=nendereco;
		salario=nsalario;
	}
	
	public void setNome(String snome){
		nome=snome;
	}
	
	public void setEndereco(String sender){
		endereco=sender;
	}
	
	public void setSalario(double dsalario){
		salario=dsalario;
	}
	public String getNome(){
		return nome;
	}
	
	public String getEndereco(){
		return endereco;
	}
	
	public double getSalario(){
		return salario;
	}
}