package formas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrecoTerca implements Preco {
	
	@Value("${precoTerca}") //annotation pra user arquivo com valores
	private int[] preco;

	@Override
	public int[] getPreco() {		
		return preco;
	}

}
