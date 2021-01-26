package formas;

public class Losango implements Forma{

	private String lados = "4 lados losango!";
	private String preco;
	
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		System.out.println("setPreco");
		this.preco = preco;
	}

	private Atributos atributos;
	
	public Losango() {		
	}
	
	public void setAtributo (Atributos atributos){
		System.out.println("entrou no setAtributos");
		this.atributos = atributos;
	}
	
	@Override
	public String getLados() {		
		return lados;
	}

	@Override
	public void setLados(String lados) {
		this.lados = lados;
	}

	@Override
	public String getCor() {
		return atributos.getCor();
	}

	@Override
	public String getTecido() {
		return atributos.getTecido();
	}
	
	public void inicializar(){
		System.out.println("inicializando Losango");		
	}
	
	public void deletando(){
		System.out.println("deletando bean");
	}

}
