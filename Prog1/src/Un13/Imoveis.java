package Un13;

public class Imoveis {
	protected String nProprietario, endereco;
	protected String va; //va= venda aluguel
	protected double valor;
	
	//construtor
	public Imoveis() {
		this.nProprietario = "";
		this.endereco = "";
		this.va = "";
		this.valor = 0;
	}
	//overload
	public Imoveis(String nProprietario, String endereco, String va, double valor) {
		this.nProprietario = nProprietario;
		this.endereco = endereco;
		this.va = va;
		this.valor = valor;
	}
	//set
	public void setnProprietario(String nProprietario) {
		this.nProprietario = nProprietario;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setVa(String va) {
		this.va = va;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	//get
	public String getnProprietario() {
		return nProprietario;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getVa() {
		return va;
	}
	public double getValor() {
		return valor;
	}
	
	
	
}
