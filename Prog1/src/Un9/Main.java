package Un9;
import javax.swing.*;
public class Main{
	public static void main(String args[]) {
		Funcionario f[ ]=new Funcionario[3];
		for (int i=0;i<3;i++){
			f[i]=new Funcionario( );
			f[i].setNome(JOptionPane.showInputDialog("Entre com o Nome"));
			f[i].setEndereco(JOptionPane.showInputDialog("Entre com o Endere�o"));
			f[i].setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Sal�rio")));
			JOptionPane.showMessageDialog(null,"Nome do Funcion�rio Cadastrado " + f[i].getNome( ));
			JOptionPane.showMessageDialog(null,"Endere�o do Funcion�rio Cadastrado " + f[i].getEndereco());
			JOptionPane.showMessageDialog(null,"Salarop do Funcion�rio Cadastrado " + f[i].getSalario());
		}
	System.exit(0);
	}
}