package un1;

import javax.swing.JOptionPane;

public class ShowInputDialog {

	public static void main(String arg[]){
		//array com as op��es de escolha
		String[] possibilidades = {"feminino", "masculino"};
		//nessa chamada de m�todo � necess�rio fazer o cast (convers�o) para String pois o dado
		//retornado � do tipo Object
		String s = (String)JOptionPane.showInputDialog(null,"Escolha a op��o:",
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
