package AD2Q4;
public class Medico {
	private String nome, espec;

	
	
	//começando a usar geradores do eclipse do eclipse
	public Medico() {
		this.nome = "";
		this.espec = "";
	}
	
	public Medico(String nome, String espec) {
		this.nome = nome;
		this.espec = espec;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEspec(String espec) {
		this.espec = espec;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEspec() {
		return espec;
	}
	
	
}
