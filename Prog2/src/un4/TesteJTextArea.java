package un4;

import javax.swing.JFrame;

public class TesteJTextArea {
	public static void main(String args[]) {
		GuiJTextAreaAnon guitextarea = new GuiJTextAreaAnon();
		guitextarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guitextarea.setSize(725, 300);
		guitextarea.setVisible(true);
	}
}