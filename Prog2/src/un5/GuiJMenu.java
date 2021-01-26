package un5;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class GuiJMenu extends JFrame {
	private final Color colorValues[] = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
	private JRadioButtonMenuItem colorItems[]; // itens do menu Cor
	private JRadioButtonMenuItem fonts[]; // itens do menu Fonte
	private JCheckBoxMenuItem styleItems[]; // itens do menu Fonte Estilo
	private JLabel displayJLabel; // exibe texto de exemplo
	private ButtonGroup fontButtonGroup; // gerencia itens do menu Fonte
	private ButtonGroup colorButtonGroup; // gerencia itens do menu Cor
	private int style; // utilizado para criar estilos de fontes

	public GuiJMenu() {
		super("Exemplo com JMenu");

		JMenu arquivoMenu = new JMenu("Arquivo"); // cria o menu Arquivo
		arquivoMenu.setMnemonic('A'); // confgura o mnemônico como A

		// cria item de menu Sobre...
		JMenuItem sobreItem = new JMenuItem("Sobre...");
		sobreItem.setMnemonic('S'); // confgura o mnemônico com A

		arquivoMenu.add(sobreItem); // adiciona o item Sobre ao menu Arquivo
		sobreItem.addActionListener(new ActionListener() { // classe interna
															// anônima
															// exibe um diálogo
															// de mensagem
															// quando o usuário
															// seleciona
															// Sobre...
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(GuiJMenu.this, "Exemplo de GUI com menus", "Sobre",
						JOptionPane.PLAIN_MESSAGE);
			} // fm do método actionPerformed
		} // fm da classe interna anônima
		); // fm da chamada para addActionListener

		JMenuItem sairItem = new JMenuItem("Sair"); // cria o item Sair
		sairItem.setMnemonic('S'); // confgura o mnemônico como S

		arquivoMenu.add(sairItem); // adiciona o item Sair ao menu Arquivo
		sairItem.addActionListener(new ActionListener() // classe interna
														// anônima
		{
			// termina o aplicativo quando o usuário clica Sair
			public void actionPerformed(ActionEvent event) {
				System.exit(0); // encerra o aplicativo
			} // fm do método actionPerformed
		} // fm da classe interna anônima
		); // fm da chamada para addActionListener

		JMenuBar bar = new JMenuBar(); // cria a barra de menus
		setJMenuBar(bar); // adiciona uma barra de menus ao aplicativo
		bar.add(arquivoMenu); // adiciona o menu File à barra de menus

		JMenu formatMenu = new JMenu("Formatar"); // cria o menu Formatar
		formatMenu.setMnemonic('F'); // confgura o mnemônico como F
		// array listando cores de string
		String colors[] = { "Preto", "Azul", "Vermelho", "Verde" };

		JMenu corMenu = new JMenu("Cor"); // cria o menu Cor
		corMenu.setMnemonic('C'); // confgura o mnemônico como C

		// cria itens do menu Cor com botões de opção
		colorItems = new JRadioButtonMenuItem[colors.length];
		colorButtonGroup = new ButtonGroup(); // agrupador de botões

		TrataEventoBotao tratabotao = new TrataEventoBotao(); // ouvinte de
																// evento para
																// os botoes

		// cria itens do menu Cor com botões de opção
		for (int count = 0; count < colors.length; count++) {
			colorItems[count] = new JRadioButtonMenuItem(colors[count]); // cria
																			// o
																			// item
			corMenu.add(colorItems[count]); // adiciona o item ao menu Cor
			colorButtonGroup.add(colorItems[count]); // adiciona ao grupo
			colorItems[count].addActionListener(tratabotao); // adiciona o
																// ouvinte a
																// cada botao
		} // fm do for

		colorItems[0].setSelected(true); // seleciona o primeiro item dos botões
											// de cor

		formatMenu.add(corMenu); // adiciona o menu Cor ao menu Format
		formatMenu.addSeparator(); // adiciona um separador no menu

		// array listando nomes de fonte
		String fontNames[] = { "Serif", "Monospaced", "SansSerif" };
		JMenu fontMenu = new JMenu("Fonte"); // cria a fonte do menu
		fontMenu.setMnemonic('n'); // confgura o mnemônico como n

		// cria itens do menu radiobutton para nomes de fonte
		fonts = new JRadioButtonMenuItem[fontNames.length];
		fontButtonGroup = new ButtonGroup(); // agrupador dos botoes das fontes

		// criar itens do menu Font com botões de opção
		for (int count = 0; count < fonts.length; count++) {
			fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
			fontMenu.add(fonts[count]); // adiciona fonte ao menu Font
			fontButtonGroup.add(fonts[count]); // adiciona ao grupo de botões
			fonts[count].addActionListener(tratabotao); // adiciona handler
		} // fm do for

		fonts[0].setSelected(true); // seleciona o primeiro item do menu Font
		fontMenu.addSeparator(); // adiciona uma barra separadora ao menu Font

		String styleNames[] = { "Bold", "Italic" }; // nomes dos estilos
		styleItems = new JCheckBoxMenuItem[styleNames.length];
		TrataEventoCheckBox tratacheck = new TrataEventoCheckBox(); // ouvinte
																	// de evento
																	// para
																	// JChec

		// criar itens do menu Style com caixas de seleção
		for (int count = 0; count < styleNames.length; count++) {
			styleItems[count] = new JCheckBoxMenuItem(styleNames[count]); // para
																			// estilo
			fontMenu.add(styleItems[count]); // adiciona ao menu Font
			styleItems[count].addItemListener(tratacheck); // handler
		} // fm do for

		formatMenu.add(fontMenu); // adiciona o menu Fonte ao menu Formatar
		bar.add(formatMenu); // adiciona o menu Formatar à barra de menus

		// confgura o rótulo para exibir texto
		displayJLabel = new JLabel("Texto de Exemplo", SwingConstants.CENTER);
		displayJLabel.setForeground(colorValues[0]);
		displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

		getContentPane().setBackground(Color.LIGHT_GRAY); // confgura o fundo
		add(displayJLabel, BorderLayout.CENTER); // adiciona displayJLabel
	} // fm do construtor

	// classe interna para tratar eventos de ação dos itens de menu
	private class TrataEventoBotao implements ActionListener {
		// processa seleções de cor e fonte
		public void actionPerformed(ActionEvent event) {
			// processa a seleção de cor
			for (int count = 0; count < colorItems.length; count++) {
				if (colorItems[count].isSelected()) {
					displayJLabel.setForeground(colorValues[count]);
					break;
				} // fm do if
			} // fm do for

			// processa a seleção de fonte
			for (int count = 0; count < fonts.length; count++) {
				if (event.getSource() == fonts[count]) {
					displayJLabel.setFont(new Font(fonts[count].getText(), style, 72));
				}
			} // fm do for

			repaint(); // redesenha o aplicativo
		} // fm do método actionPerformed
	} // fm da classe interna

	// classe interna para tratar eventos dos itens de menu com caixa de seleção
	private class TrataEventoCheckBox implements ItemListener {
		// processa seleções de estilo da fonte
		public void itemStateChanged(ItemEvent e) {
			style = 0; // inicializa o estilo
			// verifca se negrito foi selecionado
			if (styleItems[0].isSelected())
				style += Font.BOLD; // adiciona negrito ao estilo

			// verifca se itálico foi selecionado
			if (styleItems[1].isSelected())
				style += Font.ITALIC; // adiciona itálico ao estilo

			displayJLabel.setFont(new Font(displayJLabel.getFont().getName(), style, 72));
			repaint(); // redesenha o aplicativo
		} // fm do método
	} // fm da classe interna

	public static void main(String args[]) {
		GuiJMenu menu = new GuiJMenu(); // criar MenuFrame
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(580, 200); // confgura o tamanho do frame
		menu.setVisible(true); // exibe o frame
	} // fm do main()

} // fm da classe GuiJMenu
