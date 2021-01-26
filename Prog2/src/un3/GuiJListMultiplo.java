package un3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GuiJListMultiplo extends JFrame {
	private JList nomeList;
	private JList selecList;
	private String nomes[] = { "Andrea", "Cristina", "Joao", "Lucas" };
	private JButton copiaButton;

	public GuiJListMultiplo() {
		super("Exemplo JList com Multipla Seleção");
		setLayout(new FlowLayout());
		nomeList = new JList(nomes);
		nomeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		nomeList.setSelectedIndex(0);
		nomeList.setVisibleRowCount(3);
		add(new JScrollPane(nomeList)); // cria o objeto JScrollPane dentro do
										// metodo add que adiciona o JScrollPane
										// ao frame
		copiaButton = new JButton("Copia >>");
		TrataEventoBotao trataeventobotao = new TrataEventoBotao();
		copiaButton.addActionListener(trataeventobotao);
		add(copiaButton);
		selecList = new JList(); // lista vazia para armazenar os itens
									// selecionados

		selecList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		selecList.setVisibleRowCount(3);
		selecList.setFixedCellWidth(100); // confgura a largura da lista
		selecList.setFixedCellHeight(15); // confgura a altura da lista
		add(new JScrollPane(selecList));
	}

	private class TrataEventoBotao implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selecList.setListData(nomeList.getSelectedValues());
		}
	}
}