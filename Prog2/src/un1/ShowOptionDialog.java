package un1;

import javax.swing.JOptionPane;

public class ShowOptionDialog {

	public static void main(String arg[]) {
		// array de 3 posições, onde cada uma contém o texto de um botão.
		String[] options = { "Sim, por favor", "Não, obrigada", "Cancela" };
		// compare os parâmetros do método showOptionDialog com a explicação dos
		// parâmetros acima
		// parâmetro options é o array declarado anteriormente. Contém o nome
		// dos botões
		// parâmetro options[0] indica que o primeiro botão estará selecionado
		// variável n armazenará o número do botão que o usuário clicou
		int n = JOptionPane.showOptionDialog(null, "Confrma o pedido?", "Confrmação do Pedido",
				JOptionPane.YES_NO_CANCEL_OPTION, // optionType
				JOptionPane.QUESTION_MESSAGE, // messageType
				null, // sem icon
				options, options[0]);
		// n pode ser testado em relação aos valores inteiros literais 0, 1 ou 2
		// (ordem dos botões) ou em relação
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
