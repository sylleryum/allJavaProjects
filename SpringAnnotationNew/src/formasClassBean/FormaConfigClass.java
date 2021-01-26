package formasClassBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("formasClassBean")
@PropertySource("classpath:formasClassBean/details.properties")
public class FormaConfigClass {
	
	@Bean
	public Atributos modelo(){//nome do bean
		return new ModeloOldSchool();//qual bean (classe)
	}
	
	@Bean
	public Preco preco(){
		return new PrecoTerca();
	}
	
	@Bean
	public Forma losango(){
		Losango losango = new Losango(modelo(), preco());
		return losango ;
	}
	
	

}
