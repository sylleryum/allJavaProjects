package Un9;
import javax.swing.JOptionPane;
public class CadastraAdmDocente{
	public static void main(String args[]){
		Docente d1= new Docente( );
		d1.setNome(JOptionPane.showInputDialog("Entre com o Nome:"));;
		d1.setEndereco(JOptionPane.showInputDialog("Entre com o Endereco:"));
		d1.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Salario:")));
		d1.setNha(Integer.parseInt(JOptionPane.showInputDialog("Entre com o Nu.de Horas Aula Semanais:")));
		d1.setTitulacao(JOptionPane.showInputDialog("Entre com a Titulacao:"));
		Administrativo a1= new Administrativo( );
		a1.setNome(JOptionPane.showInputDialog("Entre com o Nome:"));;
		a1.setEndereco(JOptionPane.showInputDialog("Entre com o Endereco:"));
		a1.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Salario:")));
		a1.setCargo(JOptionPane.showInputDialog("Entre com o Cargo:"));
		a1.setSetor(JOptionPane.showInputDialog("Entre com o Setor:"));
		System.exit(0);
	}
}