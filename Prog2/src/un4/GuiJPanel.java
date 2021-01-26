package un4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GuiJPanel extends JFrame {
	private JPanel buttonJPanel; // painel para armazenar botões
	private JButton buttons[]; // array de botões
	private final String names[] = { "Salvar", "Editar", "Deletar", "Sair" };

	// construtor
	public GuiJPanel() {
		super("Exemplos utilizando JPanel");
		buttons = new JButton[4]; // cria botões de array

		buttonJPanel = new JPanel(); // cria JPanel
		buttonJPanel.setLayout(new GridLayout(1, buttons.length)); // confgura o
																	// layout do
																	// JPanel

		// cria e adiciona botões
		for (int count = 0; count < buttons.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttonJPanel.add(buttons[count]); // adiciona botão ao painel
		}

		add(buttonJPanel, BorderLayout.SOUTH); // adiciona painel ao JFrame na
												// região Sul
	} // fm do construtor

	public static void main(String args[]) {
		GuiJPanel panel = new GuiJPanel();
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(450, 200); // confgura o tamanho do frame
		panel.setVisible(true); // exibe o frame
	} // fm do main()
} // fm da classe