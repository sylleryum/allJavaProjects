package un3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener; //interface que trata o evento do componente JList
import javax.swing.event.ListSelectionEvent; //classe do evento
import javax.swing.ListSelectionModel; //classe que especifca o modo de seleção da lista

public class GuiJList extends JFrame {
	private JList nomeList;
	private String nomes[] = { "Andrea", "Cristina", "Joao", "Lucas" };
	private JTextField nomeTextField;

	public GuiJList() {
		super("Exemplo JList");
		setLayout(new FlowLayout());

		nomeList = new JList(nomes);
		nomeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nomeList.setSelectedIndex(0);
		nomeList.setVisibleRowCount(3);
		JScrollPane listScrollPane = new JScrollPane(nomeList);
		add(listScrollPane);
		TrataEventoList trataeventolist = new TrataEventoList();
		nomeList.addListSelectionListener(trataeventolist);

		nomeTextField = new JTextField(10);
		add(nomeTextField);
	}

	private class TrataEventoList implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {
			nomeTextField.setText(nomes[nomeList.getSelectedIndex()]);
		}
	}
} // fm da classe