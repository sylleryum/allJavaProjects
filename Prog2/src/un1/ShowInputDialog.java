package un1;

import javax.swing.JOptionPane;

public class ShowInputDialog {

	public static void main(String arg[]){
		//array com as opções de escolha
		String[] possibilidades = {"feminino", "masculino"};
		//nessa chamada de método é necessário fazer o cast (conversão) para String pois o dado
		//retornado é do tipo Object
		String s = (String)JOptionPane.showInputDialog(null,"Escolha a opção:",
		"Caixa de Entrada Customizada",
		JOptionPane.PLAIN_MESSAGE,
		null,
		possibilidades,
		possibilidades[0]);
		if (s.equals("feminino"))
		JOptionPane.showMessageDialog(null,"Feminino");
		else
		JOptionPane.showMessageDialog(null,"Masculino");
		System.exit(0);
		}
}
