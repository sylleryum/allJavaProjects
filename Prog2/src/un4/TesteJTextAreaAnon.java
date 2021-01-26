package un4;

import javax.swing.JFrame;

public class TesteJTextAreaAnon {
	public static void main(String args[]) {
		GuiJTextArea guitextarea = new GuiJTextArea();
		guitextarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guitextarea.setSize(725, 300);
		guitextarea.setVisible(true);
	}
}