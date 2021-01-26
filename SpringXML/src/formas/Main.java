package formas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// create Container
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("formaConfig.xml");

		// retrieve bean
		Forma forma = container.getBean("formaBean", Forma.class);

		// usar objeto
		System.out.println("lados: "+forma.getLados());		
		System.out.println("cor: " + forma.getCor());
		System.out.println("tecido: "+forma.getTecido());
		
		//close Container
		container.close();
	}

}
