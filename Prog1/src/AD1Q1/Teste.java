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
		//chamará o 2º somaValores pois c=double e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(c,a));
		
		//chamará o 2º somaValores pois d=double e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(d,a));
		
		//chamará o 1º somaValores pois a=int e b=int
		JOptionPane.showMessageDialog(null, ob.somaValores(a,b));
		
		//chamará o 3º somaValores pois c=double e d=double
		JOptionPane.showMessageDialog(null, ob.somaValores(c,d));
		
		//chamará o 1º somaValores pois x=int e a=int
		JOptionPane.showMessageDialog(null, ob.somaValores(x,a));
	}
}