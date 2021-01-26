package un5;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GuiJTabbedPane extends JFrame {
	public GuiJTabbedPane() {
		super("Exemplo de JTabbedPane");
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = new ImageIcon("middle.gif");
		JPanel panel1 = new JPanel(false);
		JLabel label1 = new JLabel("Texto da guia 1");
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel1.setLayout(new GridLayout(1, 1));
		panel1.add(label1);
		tabbedPane.addTab("Aba 1", icon, panel1, "Primeira guia");
		tabbedPane.setMnemonicAt(0, '1');
		JPanel panel2 = new JPanel(false);
		JLabel label2 = new JLabel("Texto da guia 2");
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel2.setLayout(new GridLayout(1, 1));
		panel2.add(label2);
		tabbedPane.addTab("Aba 2", icon, panel2, "Segunda guia");
		tabbedPane.setMnemonicAt(1, '2');
		JPanel panel3 = new JPanel(false);
		JLabel label3 = new JLabel("Texto da guia 3");
		label3.setHorizontalAlignment(JLabel.CENTER);
		panel3.setLayout(new GridLayout(1, 1));
		panel3.add(label3);
		tabbedPane.addTab("Aba 3", icon, panel3, "Terceira guia");
		tabbedPane.setMnemonicAt(2, '3');
		JPanel panel4 = new JPanel(false);
		JLabel label4 = new JLabel("Texto da guia 4");
		label4.setHorizontalAlignment(JLabel.CENTER);
		panel4.setLayout(new GridLayout(1, 1));
		panel4.add(label4);
		tabbedPane.addTab("Aba 4", icon, panel4, "Quarta guia");
		tabbedPane.setMnemonicAt(3, '4');
		// Adiciona o JTabbedPane para o frame.
		add(tabbedPane);
	}

	public static void main(String[] args) {
		GuiJTabbedPane tabbedpane = new GuiJTabbedPane();
		tabbedpane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabbedpane.setSize(350, 200); // confgura o tamanho do frame
		tabbedpane.setVisible(true); // exibe o frame
	}
}