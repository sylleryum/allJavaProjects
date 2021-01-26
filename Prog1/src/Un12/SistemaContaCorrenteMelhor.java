package Un12;
import javax.swing.*;
public class SistemaContaCorrenteMelhor {
	public static void main(String args[]) {
		Conta cta[ ]=new Conta[3];
		Cliente cli[ ]= new Cliente[2];
		int pcli=0, pcta=0;
			while (true) {
			//OP 1
			String op= JOptionPane.showInputDialog("1 – Cadastra Cliente e Conta 2 – Cadastra Conta para Cliente 3 - Sair");
			if (op.equalsIgnoreCase("1")){
				cli[pcli] = new Cliente( );
				cli[pcli].setNome(JOptionPane.showInputDialog("Entre com o Nome"));
				cli[pcli].setEndereco(JOptionPane.showInputDialog("Entre com o Endereço"));
				cli[pcli].setCpf(Integer.parseInt(JOptionPane.showInputDialog("Entre com o CPF")));
				cta[pcta] = new Conta();
				cta[pcta].setNumero(Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero")));
				cta[pcta].setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Entre com o saldo")));
				cta[pcta].setCliente(cli[pcli]);

				JOptionPane.showMessageDialog(null, "nome cliente: " + cli[pcli].getNome() + 
						"\n endereco " + cli[pcli].getEndereco() +
						"\n cpf: " +cli[pcli].getCpf() + 
						"\n numero conta" + cta[pcta].getNumero() +
						"\n saldo: " + cta[pcta].getSaldo());
				JOptionPane.showMessageDialog(null, "cliente associado com a conta: " +cta[pcta].getCliente().getNome());
				pcli ++ ; //igual a pcli = pcli + 1;
				pcta ++ ;
			}
			else
			//OP 2
			if (op.equalsIgnoreCase("2")){
				String nomecli = (JOptionPane.showInputDialog("Entre com o Nome do Cliente" ));
				for (int i=0;i<pcli;i++) {
					if (nomecli.equalsIgnoreCase(cli[i].getNome( ))){ //achou o cliente
						JOptionPane.showMessageDialog(null, "Cliente :" + cli[i].getNome());
						cta[pcta] = new Conta();
						cta[pcta]. setNumero(Integer.parseInt(JOptionPane.showInputDialog
						("Entre com o Numero")));
						cta[pcta].setSaldo(Double.parseDouble(JOptionPane.
						showInputDialog("Entre com o saldo")));
						cta[pcta].setCliente(cli[i]);
						pcta ++ ; //incrementa o contador de contas
						break; //instrução de interrompe a repetição (for)
					}
				}
			} //fi m da op = = 2
			else
			if (op.equalsIgnoreCase("3"))
				break; //sai do while
			} 
		System.exit(0);
	} 
}

