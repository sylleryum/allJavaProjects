package formas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //como não tá setado o nome do bean será nome da classe minusculo (losango)
public class Losango implements Forma{
	
	private Preco preco;
	private String lados = "4 lados losango!";
	@Autowired //não precisa setter(abaixo), pode colocar direto no private do tipo da interface
	@Qualifier("modeloOldSchool") //nome do bean (padrao=classe com primeira letra minuscula)
	private Atributos atributos;
	
//	@Autowired //pode ser qualquer nome, autowired buscará por classe implementando a interface (Atributos)
//	public void setAtributo (Atributos atributos){
//		System.out.println("entrou no setAtributos");
//		this.atributos = atributos;
//	}
	
	@Autowired
	@Qualifier("precoTerca")
	public void setPreco(Preco preco){
		this.preco = preco;
	}
	
	public Losango() {
		System.out.println("Instanciado Losango");
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

	@Override
	public void setCor(String Cor) {		
		
	}

	@Override
	public void setTecido(String tecido) {
		
	}
	
	public int[] getPreco(){
		return preco.getPreco();
	}

}
