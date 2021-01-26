package formas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("formaBean")
public class Quadrado  implements Forma{
	
	private Atributos atributo;
	private String lados = "4 lados";
	
	//@Autowired //procura interface Atributos
	public Quadrado(Atributos atributo) {
		super();
		this.atributo = atributo;
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
	public void setCor(String Cor) {		
		
	}

	@Override
	public String getCor() {		
		return atributo.getCor();
	}

	@Override
	public void setTecido(String tecido) {		
		
	}

	@Override
	public String getTecido() {
		return atributo.getTecido();
	}
	
	


}
