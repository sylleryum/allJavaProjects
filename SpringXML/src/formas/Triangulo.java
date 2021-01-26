package formas;

public class Triangulo implements Forma{

	private String lados = "3 lados";
	private Atributos atributos;
	
	public Triangulo(Atributos atributos) {
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

}
