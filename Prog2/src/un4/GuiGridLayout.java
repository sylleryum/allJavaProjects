package un4;

import java.awt.GridLayout;
import java.awt.Container; //importação da classe Container
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GuiGridLayout extends JFrame {
	private JButton buttons[]; // array de botões
	private final String names[] = { "Botão 1", "Botão 2", "Botão 3", "Botão 4", "Botão 5", "Botão 6" }; // array
																											// nome
																											// dos
																											// botões
	private Container container; // contêiner do frame
	private GridLayout gridLayout; // primeiro gridlayout
	// construtor sem argumento

	public GuiGridLayout() {
		super("Exemplo com Gerenciador GridLayout");
		gridLayout = new GridLayout(2, 3, 5, 5); // 2 por 3; lacunas de 5

		container = getContentPane(); // obtém painel de conteúdo
		container.setLayout(gridLayout); // confgura o layout JFrame
		buttons = new JButton[names.length]; // cria array de JButtons

		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			container.add(buttons[count]); // adiciona o botão ao JFrame
		} // fnal do for

	} // fm do construtor GuiGridLayout

	public static void main(String args[]) {
		GuiGridLayout gridLayout = new GuiGridLayout();
		gridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridLayout.setSize(300, 200); // confgura o tamanho do frame
		gridLayout.setVisible(true); // exibe o frame
	} // fm de main

} // fm da classe