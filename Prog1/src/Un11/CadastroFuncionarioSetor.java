package Un11;
import javax.swing.*;
public class CadastroFuncionarioSetor {
	public static void main(String args[]) {
		Setor s[]=new Setor[3];
		s[0] = new Setor(1,"Financeiro");
		s[1] = new Setor(2,"Compras");
		s[2] = new Setor(3,"Almoxarifado");
		Funcionario f=new Funcionario( );
		f.setNome(JOptionPane.showInputDialog("Entre com o Nome"));
		f.setEndereco(JOptionPane.showInputDialog("Entre com o Endere�o"));
		f.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Sal�rio")));
		int codsetor=Integer.parseInt(JOptionPane.showInputDialog("Entre com o C�digo do Setor"));
		for (int i=0;i<3;i++){
		if (codsetor == s[i].getCodigo( ))
		f.setSetor(s[i]);
		}
		Funcionario f2=new Funcionario( );
		f2.setNome(JOptionPane.showInputDialog("Entre com o Nome"));
		f2.setEndereco(JOptionPane.showInputDialog("Entre com o Endere�o"));
		f2.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Sal�rio")));
		codsetor=Integer.parseInt(JOptionPane.showInputDialog("Entre com o C�digo do Setor"));
		for (int i=0;i<3;i++){
		if (codsetor == s[i].getCodigo( ))
		f2.setSetor(s[i]);
		}
		Funcionario f3=new Funcionario( );
		f3.setNome(JOptionPane.showInputDialog("Entre com o Nome"));
		f3.setEndereco(JOptionPane.showInputDialog("Entre com o Endere�o"));
		f3.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Sal�rio")));
		codsetor=Integer.parseInt(JOptionPane.showInputDialog("Entre com o C�digo do Setor"));
		for (int i=0;i<3;i++){
		if (codsetor == s[i].getCodigo( ))
		f3.setSetor(s[i]);
		}
		JOptionPane.showMessageDialog(null,"Nome e Setor dos Funcion�rios \n" + f.getNome()
		+ " "+f.getNomeSetorFunc( ) + "\n" + f2.getNome( ) +" "+ f2.getNomeSetorFunc( )
		+ "\n" + f3.getNome( ) +" "+ f3.getNomeSetorFunc( ) );
		System.exit(0);
		}
}
