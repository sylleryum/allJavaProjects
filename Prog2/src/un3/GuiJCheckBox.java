package un3;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class GuiJCheckBox extends JFrame {

	private JTextField textfeld;
	private JCheckBox checkNegrito;
	private JCheckBox checkItalico;

	public GuiJCheckBox() {
		super("Exemplo JCheckBox");
		setLayout(new FlowLayout()); // confgura o layout do frame

		textfeld = new JTextField("Tecnologo em Web Design e Programação");
		textfeld.setFont(new Font("Serif", Font.PLAIN, 14));
		add(textfeld); // adiciona textfeld ao frame

		checkNegrito = new JCheckBox("Negrito");// cria o primeiro componente
												// JCheckBox
		checkItalico = new JCheckBox("Italico");// cria o segundo componente
		add(checkNegrito);// adiciona os dois componentes ao frame
		add(checkItalico);

		// cria o objeto ouvinte de evento
		TrataEventoCheckBox trataevento = new TrataEventoCheckBox();
		// adiciona esse objeto a cada um dos componentes. Veja que o método
		// agora é addItemListener()
		checkNegrito.addItemListener(trataevento);
		checkItalico.addItemListener(trataevento);

	}

	private class TrataEventoCheckBox implements ItemListener {
		private int valorNegrito = Font.PLAIN; // controla o estilo da fonte
												// Negrito
		private int valorItalico = Font.PLAIN; // controla o estilo da fonte
												// Itálico

		public void itemStateChanged(ItemEvent event) {

			// verifca a origem do evento. Trata o evento para o componente
			// checkNegrito
			if (event.getSource() == checkNegrito) {
				if (checkNegrito.isSelected())
					valorNegrito = Font.BOLD;
				else
					valorNegrito = Font.PLAIN;
			}

			// verifca a origem do evento. Trata o evento para o componente
			// checkItalico
			if (event.getSource() == checkItalico) {
				if (checkItalico.isSelected())
					valorItalico = Font.ITALIC;
				else
					valorItalico = Font.PLAIN;
			}

			textfeld.setFont(new Font("Serif", valorNegrito + valorItalico, 14));
		}
	}
}