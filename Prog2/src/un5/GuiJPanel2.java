package un5;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiJPanel2 extends JFrame {
	private JLabel labelNome;
	private JLabel labelEndereco;
	private JLabel labelCidade;
	private JTextField textfeldNome;
	private JTextField textfeldEndereco;
	private JTextField textfeldCidade;
	private JPanel buttonJPanel; // painel para armazenar botões	
	private JButton buttons[] = new JButton[4]; // array de botões
	private final String names[] = { "Salvar", "Editar", "Deletar", "Sair" };

	// construtor sem argumento
	public GuiJPanel2() {
		super("Exemplo com Multiplos Paineis");
		labelNome = new JLabel("Nome");
		labelEndereco = new JLabel("Endereço");
		labelCidade = new JLabel("Cidade");
		textfeldNome = new JTextField(30);
		textfeldEndereco = new JTextField(30);
		textfeldCidade = new JTextField(30);
		JPanel buttonJPanel = new JPanel(new GridLayout(0, 4)); // cria JPanel
																// dos botoes
		// cria e adiciona botões ao panel
		for (int count = 0; count < buttons.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttonJPanel.add(buttons[count]); // adiciona botão ao painel
		}
		JPanel labelPane = new JPanel(new GridLayout(0, 1)); // cria JPanel dos
																// labels
		labelPane.add(labelNome); // adiciona label´s ao panel
		labelPane.add(labelEndereco);
		labelPane.add(labelCidade);
		JPanel feldPane = new JPanel(new GridLayout(0, 1));// cria JPanel dos
															// textedit
		feldPane.add(textfeldNome); // adiciona textfeld´s ao panel
		feldPane.add(textfeldEndereco);
		feldPane.add(textfeldCidade);
		JPanel principalPane = new JPanel(new BorderLayout());// cria JPanel
																// principal
		principalPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		principalPane.add(labelPane, BorderLayout.CENTER);// adiciona painel ao
															// JFrame na região
															// Sul
		principalPane.add(feldPane, BorderLayout.EAST);// adiciona painel ao
														// JFrame na região Sul
		principalPane.add(buttonJPanel, BorderLayout.SOUTH); // adiciona painel
																// ao JFrame na
																// região Sul
		add(principalPane, BorderLayout.CENTER);
	} // fm do construtor

	public static void main(String args[]) {
		GuiJPanel2 panel2 = new GuiJPanel2();
		panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setSize(600, 200); // confgura o tamanho do frame
		panel2.setVisible(true); // exibe o frame
	} // fm de main
} // fm da classe