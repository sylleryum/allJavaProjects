package un1;

import javax.swing.JOptionPane;

public class DialogMessage {

	public static void main(String[] args) {

		// chamada do m�todo passando somente os dois primeiros argumentos.
		// Mostra a
		// mensagem e �cone default de informa��o
		JOptionPane.showMessageDialog(null, "Mensagem de Informa��o");
		// chamada do m�todo passando somente os quatro argumentos explicados
		// acima
		// t�tulo customizado e �cone de informa��o
		JOptionPane.showMessageDialog(null, "Mensagem de Informa��o", "Informa��o", JOptionPane.INFORMATION_MESSAGE);
		// t�tulo customizado e �cone de perigo
		JOptionPane.showMessageDialog(null, "Mensagem de Perigo", "Perigo", JOptionPane.WARNING_MESSAGE);
		// t�tulo customizado e �cone de erro
		JOptionPane.showMessageDialog(null, "Mensagem de Erro", "Erro", JOptionPane.ERROR_MESSAGE);
		// t�tulo customizado e �cone de quest�o
		JOptionPane.showMessageDialog(null, "Mensagem de Questionamento", "Questionamento",
				JOptionPane.QUESTION_MESSAGE);
		// t�tulo customizado e sem �cone
		// JOptionPane.showMessageDialog(null,"Mensagem simples","Simples",
		// JOptionPane.PLAIN_
		// MESSAGE);
	}
} // fm da classe
