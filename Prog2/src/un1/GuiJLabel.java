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
		label1 = new JLabel("Tecn�logo em Web Design e Programa��o");
		label1.setToolTipText("Este � o rotulo 1");
		add(label1);
		Icon bug = new ImageIcon("metal-Error.gif"); // esta imagem pode ser
														// substitu�da por outra
		label2 = new JLabel("R�tulo com texto e imagem", bug, SwingConstants.LEFT);
		label2.setToolTipText("Este � o r�tulo 2");
		add(label2);
		label3 = new JLabel();
		label3.setText("R�tulo com imagem e texto embaixo");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este � o r�tulo 3");
		add(label3);
	}
}