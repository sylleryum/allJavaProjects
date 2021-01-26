import javax.swing.*;
class Un4e2 {
public static void main(String args[])
{
	int h, b, a;
	
	h = Integer.parseInt(JOptionPane.showInputDialog("Digite altura"));
	b = Integer.parseInt(JOptionPane.showInputDialog("Digite base"));
	a = (b * h) /2;
	JOptionPane.showMessageDialog(null, "A area eh " +a);
}
}