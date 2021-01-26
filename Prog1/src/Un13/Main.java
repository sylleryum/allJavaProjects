package Un13;
import javax.swing.*;
public class Main {
	public static void main(String args[]) {
		int cA=0, cC=0;
		Aptos a[] = new Aptos[2];
		Casas c[] = new Casas[2];
		
			//apto
			boolean cLoop=true;
			while (cLoop==true){
				for (int i=0;i<2;i++){
					int op=Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada \n"
							+ "1 para cadastrar apto \n"
							+ "2 para cadastrar casa"));
					System.out.println("i afterrun: "+i);
					if (op==1){
						a[cA] = new Aptos();
						a[cA].setnProprietario(JOptionPane.showInputDialog("Nome do proprietario: "));
						cA++;
						//break;
					} else if (op==2){
						c[cC] = new Casas();
						c[cC].setnProprietario(JOptionPane.showInputDialog("Nome do proprietario: "));
						c[cC].setEndereco(JOptionPane.showInputDialog("Endereço: "));
						c[cC].setVa(JOptionPane.showInputDialog("1 para venda \n 2 para aluguel: "));
						c[cC].setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor ")));
						c[cC].setPisc(Integer.parseInt(JOptionPane.showInputDialog("1 para tem piscina, 2 não tem")));
						JOptionPane.showMessageDialog(null, "Casa cadastrada com sucesso!");
						cC++;
						//break;
					} else{
						JOptionPane.showMessageDialog(null, "Opcao errada");
						cLoop=false;
						/*if (i>0){
							i=i-1;
						}*/
					}					
					if (i>=1){
						cLoop=false;
					}
			}
			//System.out.println("buebd");
		}
	}
}
	