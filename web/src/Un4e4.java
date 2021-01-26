import javax.swing.JOptionPane;

public class Un4e4 {
	public static void main(String args[])
	{
		int idade, anos;
		idade = Integer.parseInt(JOptionPane.showInputDialog("entre com a idade"));
		anos = idade * 365;
		JOptionPane.showMessageDialog(null, "viveu: " +anos);		
	}
}
