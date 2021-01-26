import javax.swing.JOptionPane;

public class Un4E1 {
	public static void main(String args[])
	{
		int n1, soma;
		n1 =Integer.parseInt(JOptionPane.showInputDialog("Entre com um numero"));
		soma = n1 * n1;
		JOptionPane.showMessageDialog(null,"A soma é" +soma);
		
	}
}
