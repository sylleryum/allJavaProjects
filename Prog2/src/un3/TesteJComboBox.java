package un3;

import javax.swing.JFrame;

public class TesteJComboBox {
	public static void main(String arg[]) {
		GuiJComboBox guijcombobox = new GuiJComboBox();
		guijcombobox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guijcombobox.setSize(275, 280);
		guijcombobox.setVisible(true);
	}
}