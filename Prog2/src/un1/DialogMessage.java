package un1;

import javax.swing.JOptionPane;

public class DialogMessage {

	public static void main(String[] args) {

		// chamada do método passando somente os dois primeiros argumentos.
		// Mostra a
		// mensagem e ícone default de informação
		JOptionPane.showMessageDialog(null, "Mensagem de Informação");
		// chamada do método passando somente os quatro argumentos explicados
		// acima
		// título customizado e ícone de informação
		JOptionPane.showMessageDialog(null, "Mensagem de Informação", "Informação", JOptionPane.INFORMATION_MESSAGE);
		// título customizado e ícone de perigo
		JOptionPane.showMessageDialog(null, "Mensagem de Perigo", "Perigo", JOptionPane.WARNING_MESSAGE);
		// título customizado e ícone de erro
		JOptionPane.showMessageDialog(null, "Mensagem de Erro", "Erro", JOptionPane.ERROR_MESSAGE);
		// título customizado e ícone de questão
		JOptionPane.showMessageDialog(null, "Mensagem de Questionamento", "Questionamento",
				JOptionPane.QUESTION_MESSAGE);
		// título customizado e sem ícone
		// JOptionPane.showMessageDialog(null,"Mensagem simples","Simples",
		// JOptionPane.PLAIN_
		// MESSAGE);
	}
} // fm da classe
