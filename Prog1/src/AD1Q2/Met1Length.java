package AD1Q2;
import javax.swing.*;
class Met1Length {
	public static void main(String args[])
	{
		String palavra;
		int len;
		
		/*String arr[]={"oi", "ola", "teste"};
		int len2 = arr[2].length();
		System.out.println("3ª string tem : " +len2);*/
		
		palavra=JOptionPane.showInputDialog("entre com uma palavra: ");
		len=palavra.length();
		if (len >= 5){
			JOptionPane.showMessageDialog(null, "Palavra com mais de 4 letras:  \n" +len);			
		}
		else{
			JOptionPane.showMessageDialog(null, "Palavra com menos de 5 letras: \n" +len);			
		}
		
	}
}