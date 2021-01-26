package formas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("formas")
@PropertySource("classpath:formas/details.properties")
public class FormaConfigClass {
	
//	@Bean
//	public Atributos modeloConceptual (){
//		return new ModeloConceptual();
//	}
//	
//	@Bean
//	public Preco precoSegunda (){
//		return new PrecoSegunda();
//	}
//	
//	@Bean
//	public Forma losango(){
//		return new Losango(modeloConceptual());
//	}
	
	

}
