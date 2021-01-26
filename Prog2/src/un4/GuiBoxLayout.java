package un4;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiBoxLayout extends JFrame {
	private JLabel labelNome;
	private JLabel labelEndereco;
	private JLabel labelCidade;
	private JTextField textfeldNome;
	private JTextField textfeldEndereco;
	private JTextField textfeldCidade;

	private BoxLayout boxLayout; // primeiro gridlayout

	// construtor sem argumento
	public GuiBoxLayout() {
		super("Exemplo com Gerenciador BoxLayout");
		boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS); // verticalmente

		setLayout(boxLayout); // confgura o layout JFrame

		labelNome = new JLabel("Nome");
		add(labelNome);

		textfeldNome = new JTextField(30);
		add(textfeldNome);
		labelEndereco = new JLabel("Endereço");
		add(labelEndereco);

		textfeldEndereco = new JTextField(30);
		add(textfeldEndereco);

		labelCidade = new JLabel("Cidade");
		add(labelCidade);

		textfeldCidade = new JTextField(30);
		add(textfeldCidade);

	} // fm do construtor GuiGridLayout

	public static void main(String args[]) {
		GuiBoxLayout boxLayout = new GuiBoxLayout();
		boxLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boxLayout.setSize(300, 200); // confgura o tamanho do frame
		boxLayout.setVisible(true); // exibe o frame
	} // fm do main

} // fm da classe