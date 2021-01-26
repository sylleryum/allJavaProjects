package Un9;
import javax.swing.*;
public class Main{
	public static void main(String args[]) {
		Funcionario f[ ]=new Funcionario[3];
		for (int i=0;i<3;i++){
			f[i]=new Funcionario( );
			f[i].setNome(JOptionPane.showInputDialog("Entre com o Nome"));
			f[i].setEndereco(JOptionPane.showInputDialog("Entre com o Endereço"));
			f[i].setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Salário")));
			JOptionPane.showMessageDialog(null,"Nome do Funcionário Cadastrado " + f[i].getNome( ));
			JOptionPane.showMessageDialog(null,"Endereço do Funcionário Cadastrado " + f[i].getEndereco());
			JOptionPane.showMessageDialog(null,"Salarop do Funcionário Cadastrado " + f[i].getSalario());
		}
	System.exit(0);
	}
}