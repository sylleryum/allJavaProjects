package un1;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.*;

public class GuiJLabel extends JFrame {
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;

	public GuiJLabel() {
		super("Exemplo JLabel");
		setLayout(new FlowLayout());
		label1 = new JLabel("Tecnólogo em Web Design e Programação");
		label1.setToolTipText("Este é o rotulo 1");
		add(label1);
		Icon bug = new ImageIcon("metal-Error.gif"); // esta imagem pode ser
														// substituída por outra
		label2 = new JLabel("Rótulo com texto e imagem", bug, SwingConstants.LEFT);
		label2.setToolTipText("Este é o rótulo 2");
		add(label2);
		label3 = new JLabel();
		label3.setText("Rótulo com imagem e texto embaixo");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este é o rótulo 3");
		add(label3);
	}
}