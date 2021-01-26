package formasClassBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class PrecoSegunda implements Preco {

	@Value("${precoSegunda}") //annotation pra user arquivo com valores
	private int[] preco;
	
	@Override
	public int[] getPreco() {		
		return preco;
	}

}
