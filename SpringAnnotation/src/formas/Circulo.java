package formas;

import org.springframework.stereotype.Component;

//@Component("formaBean")
public class Circulo implements Forma{
	private String lados = "nenhum lados";
	


	public String getLados() {
		return lados;
	}

	public void setLados(String lados) {
		this.lados = lados;
	}

	@Override
	public void setCor(String Cor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTecido(String tecido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTecido() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
