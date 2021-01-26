package Un11;
public class Funcionario {
	private String nome, endereco;
	private double salario;
	private Setor setor;
	
	public Funcionario( )
	{
	nome="";
	endereco="";
	salario=0;
	setor = null;
	}
	public void setNome(String snome)
	{
	nome=snome;
	}
	
	public void setEndereco(String sender)
	{
	endereco=sender;
	}
	
	public void setSalario(double dsalario)
	{
	salario=dsalario;
	}
	public String getNome()
	{
	return nome;
	}
	
	public String getEndereco()
	{
	return endereco;
	}
	
	public double getSalario()
	{
	return salario;
	}
	
	public void setSetor (Setor ssetor)
	{
	setor = ssetor;
	}
	
	public Setor getSetor( )
	{
	return setor;
	}
	
	public String getNomeSetorFunc( ){
	return setor.getNomeSetor( );
	}
}
