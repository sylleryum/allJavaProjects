package un1;

import javax.swing.JOptionPane;

public class ShowOptionDialog {

	public static void main(String arg[]) {
		// array de 3 posi��es, onde cada uma cont�m o texto de um bot�o.
		String[] options = { "Sim, por favor", "N�o, obrigada", "Cancela" };
		// compare os par�metros do m�todo showOptionDialog com a explica��o dos
		// par�metros acima
		// par�metro options � o array declarado anteriormente. Cont�m o nome
		// dos bot�es
		// par�metro options[0] indica que o primeiro bot�o estar� selecionado
		// vari�vel n armazenar� o n�mero do bot�o que o usu�rio clicou
		int n = JOptionPane.showOptionDialog(null, "Confrma o pedido?", "Confrma��o do Pedido",
				JOptionPane.YES_NO_CANCEL_OPTION, // optionType
				JOptionPane.QUESTION_MESSAGE, // messageType
				null, // sem icon
				options, options[0]);
		// n pode ser testado em rela��o aos valores inteiros literais 0, 1 ou 2
		// (ordem dos bot�es) ou em rela��o
		// aos atributos static fnal da classe JOptionPane: YES_OPTION,
		// NO_OPTION E CANCEL_OPTION.
		if ((n == 0) || (n == JOptionPane.YES_OPTION))
			JOptionPane.showMessageDialog(null, "Pedido confrmado");
		else if (n == 1)
			JOptionPane.showMessageDialog(null, "Pedido negado");
		else if (n == 2)
			JOptionPane.showMessageDialog(null, "Pedido cancelado");
		else if (n == JOptionPane.CLOSED_OPTION)
			JOptionPane.showMessageDialog(null, "Janela fechada");
		System.exit(0);
		// o atributo JOptionPane.CLOSED_OPTION indica que a janela foi fechada.
	}
}
