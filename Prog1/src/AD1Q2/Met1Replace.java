package AD1Q2;
import javax.swing.*;
public class Met1Replace {
	public static void main(String args[])	{
		//programa que recebe frase e substitur expressão
		String frase, oldF, newF, fraseNew;
		frase =JOptionPane.showInputDialog("Digite uma frase: ");
		oldF=JOptionPane.showInputDialog("Digite uma expressao para subistituir: ");
		newF=JOptionPane.showInputDialog("Subistituir por: ");
		fraseNew = frase.replace(oldF, newF);
		JOptionPane.showMessageDialog(null, "A Frase ficou: "+fraseNew);
	}
}
