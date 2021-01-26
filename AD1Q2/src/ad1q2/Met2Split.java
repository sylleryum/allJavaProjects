package ad1q2;
import javax.swing.*;
public class Met2Split {
	public static void main(String args[])
	{
		String NomeSplit;
		String vRecebe[];
		
		//Programa que recebe diversos nomes separados por ";" 
		//e apresenta-os separadamente
		NomeSplit =JOptionPane.showInputDialog("Digite o primeiro nome de todos os alunos separados por ; ");
		vRecebe = NomeSplit.split(";");
		JOptionPane.showMessageDialog(null, "Os alunos são");
		for(int n=1;n<=vRecebe.length;n++){
			JOptionPane.showMessageDialog(null,vRecebe[n-1] );
		}
		
	}

}