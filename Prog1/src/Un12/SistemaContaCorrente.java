package Un12;
import javax.swing.*;
public class SistemaContaCorrente {
	public static void main(String args[]) {
		Conta cta[ ]=new Conta[3];
		Cliente cli[ ]= new Cliente[2];
		//Cadastrar o primeiro cliente com uma conta corrente
		cli[0] = new Cliente( );
		cli[0]. setNome(JOptionPane.showInputDialog("Entre com o Nome"));
		cli[0].setEndereco(JOptionPane.showInputDialog("Entre com o Endereço"));
		cli[0].setCpf(Integer.parseInt(JOptionPane.showInputDialog("Entre com o CPF")));
		cta[0] = new Conta();
		cta[0]. setNumero(Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero")));
		cta[0].setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Entre com o saldo")));
		cta[0].setCliente(cli[0]);
		//cadastrar o segundo cliente e sua conta
		cli[1] = new Cliente( );
		cli[1]. setNome(JOptionPane.showInputDialog("Entre com o Nome"));
		cli[1].setEndereco(JOptionPane.showInputDialog("Entre com o Endereço"));
		cli[1].setCpf(Integer.parseInt(JOptionPane.showInputDialog("Entre com o CPF")));
		cta[1] = new Conta();
		cta[1]. setNumero(Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero")));
		cta[1].setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Entre com o saldo")));
		cta[1].setCliente(cli[1]);
		//cadastrar outra conta e associar ao primeiro cliente.
		cta[2] = new Conta();
		cta[2]. setNumero(Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero")));
		cta[2].setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Entre com o saldo")));
		cta[2].setCliente(cli[0]);
		//listar o número da conta, saldo e nome de todos os clientes cadastrados
		JOptionPane.showMessageDialog(null," Número da conta – Saldo - Nome dos Clientes \n" +
		cta[0].getNumero( ) + " - "+cta[0].getSaldo( ) + " - " +cta[0].getCliente( ).getNome( ) + "\n" +
		cta[1].getNumero( ) + " - "+cta[1].getSaldo( ) + " - " +cta[1].getCliente( ).getNome( ) + "\n" +
		cta[2].getNumero( ) + " - "+cta[2].getSaldo( ) + " - " +cta[2].getCliente( ).getNome( ) );
		
		System.exit(0);
		}

}
