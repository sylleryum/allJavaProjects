package un3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GuiJComboBox extends JFrame {
	private JComboBox listadecores; // componente JComboBox
	private String nomesCor[] = { "Preto", "Azul", "Ciano", "CinzaEscuro", "Cinza", "Verde", "Cinza Claro", "Magenta",
			"Laranja", "Rosa", "Vermelho", "Branco", "Amarelo" }; // array criado en inicializado com o nome das cores
	private Color cores[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green,
			Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow }; // array
																												// do
	public GuiJComboBox() {
		super("Exemplo JComboBox");
		setLayout(new FlowLayout()); // confgura o gerenciador de layout
										// FlowLayout
		listadecores = new JComboBox(nomesCor);
		listadecores.setMaximumRowCount(13);
		add(listadecores); // adiciona o JComboBox ao frame

		TratadorComboBox tratacombo = new TratadorComboBox(); // cria o objeto ouvinte de evento
		listadecores.addItemListener(tratacombo); // registra o objeto ouvinte ao componente

		getContentPane().setBackground(cores[0]); // confgura cor do frame para a primeira cor do array cores, no caso, a cor
													// preto.
	}

	private class TratadorComboBox implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			getContentPane().setBackground(cores[listadecores.getSelectedIndex()]);
		}
	}

}// fm da classe GuiJComboBox