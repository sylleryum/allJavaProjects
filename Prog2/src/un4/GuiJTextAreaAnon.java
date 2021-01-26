package un4;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class GuiJTextAreaAnon extends JFrame {
	private JTextArea textArea1; // exibe o texto original
	private JTextArea textArea2; // exibe o texto destacado
	private JButton copiaButton; // copia o texto

	public GuiJTextAreaAnon() {
		super("Exemplo JTextArea");
		setLayout(new FlowLayout());

		String textOriginal = "Desenvolver habilidades que propiciem ao \n"
				+ "educando a capacidade de criar, programar e implantar sistemas \n"
				+ "computacionais em ambientes WEB, com embasamento teórico e sólida formação prática.";

		textArea1 = new JTextArea(textOriginal, 15, 25); // cria textarea1,
															// confgura linhas e
															// colunas
		add(new JScrollPane(textArea1)); // adiciona scrollpane ao frame
		copiaButton = new JButton("Copiar >>>"); // cria botão de cópia
		add(copiaButton);
		
		copiaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea2.setText(textArea1.getSelectedText());
			}
		});

		textArea2 = new JTextArea(15, 25); // cria segundo textarea
		textArea2.setEditable(false); // desativa a edição
		add(new JScrollPane(textArea2)); // adiciona scrollpane ao frame
	} // fm do construtor
} // fm da classe