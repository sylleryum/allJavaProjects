package ad;

public class Pessoa {

	private int pessoaID;
	private String nome;
	private int idade;
	private String dataNasc;
	private String cidade;
	private String estadoCivil;
	
	public Pessoa(String nome, int idade, String dataNasc, String cidade, String estadoCivil) {
		this.nome = nome;
		this.idade = idade;
		this.dataNasc = dataNasc;
		this.cidade = cidade;
		this.estadoCivil = estadoCivil;
	}
	
	public Pessoa(int id) {
		this.pessoaID = id;
	}
	
	public Pessoa(){		
	}

	public int getPessoaID() {
		return pessoaID;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setPessoaID(int pessoaID) {
		this.pessoaID = pessoaID;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estadoCivil;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
