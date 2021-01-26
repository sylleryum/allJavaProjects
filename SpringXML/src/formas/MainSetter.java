package formas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSetter {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("formaConfig.xml");
		Losango forma = container.getBean("formaBeanLosango", Losango.class);

		// usar objeto
		System.out.println("lados: " + forma.getLados());
		System.out.println("cor: " + forma.getCor());
		System.out.println("tecido: " + forma.getTecido());
		System.out.println(forma.getPreco());

		// close Container
		container.close();

	}

}
