package formas;

public class Circulo implements Forma{
	private String lados = "nenhm lados";
	private Atributos atributos;
	

	public Circulo(Atributos atributos) {
		this.atributos = atributos;
	}

	public String getLados() {
		return lados;
	}

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
	
}
