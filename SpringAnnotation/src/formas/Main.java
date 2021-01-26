package formas;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// create Container
		//ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("formaConfig.xml");
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(FormaConfigClass.class);

		// retrieve bean com arquivo de valor
		Losango forma = container.getBean("losango", Losango.class);
		
		//retrieve bean com interface
		//Forma forma = container.getBean("losango", Forma.class);

		// usar objeto
		System.out.println("lados: "+forma.getLados());
		System.out.println("Cor: "+forma.getCor());
		System.out.println("Tecido: "+forma.getTecido());
		
		for (int i=0;i<forma.getPreco().length;i++){
			System.out.println("Preço: "+forma.getPreco()[i]);
		}
		
		
		
		//close Container
		container.close();
	}

}
