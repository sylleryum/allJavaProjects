package AD1Q1;
import javax.swing.*;
public class Teste {
	public static void main(String[] args) {
		Sobrecarga ob = new Sobrecarga();
		int a = 1;
		int b = 2;
		int x = 3;
		double c = 4;
		double d = 5;
		//chamar� o 2� somaValores pois c=double e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(c,a));
		
		//chamar� o 2� somaValores pois d=double e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(d,a));
		
		//chamar� o 1� somaValores pois a=int e b=int
		JOptionPane.showMessageDialog(null, ob.somaValores(a,b));
		
		//chamar� o 3� somaValores pois c=double e d=double
		JOptionPane.showMessageDialog(null, ob.somaValores(c,d));
		
		//chamar� o 1� somaValores pois x=int e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(x,a));
	}
}