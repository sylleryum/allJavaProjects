package formas;

public class Quadrado  implements Forma{
	
	private String lados = "4 lados";
	private Atributos atributos;
	
	public Quadrado() {		
		System.out.println("oioi");
	}
	
	public Quadrado(Atributos atributos) {
		this.atributos = atributos;
	}
//	public void setAtributo (Atributos atributos){
//		System.out.println("entrou no setAtributos");
//		this.atributos = atributos;
//	}
	
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
