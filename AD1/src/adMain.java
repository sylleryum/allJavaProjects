import javax.swing.*;
public class adMain{
	public static void main(String args[]) {
		
		//sobrecarga de construtor foi criada em adClasse porem 
		//não será atribuido valores aqui
		adClasse j1=new adClasse();
		adClasse j2=new adClasse();
		adClasse j3=new adClasse();

		j1.setNome(JOptionPane.showInputDialog("Entre com o nome do jogador 1: "));
		j1.setNomeClube(JOptionPane.showInputDialog("Entre com o nome do clube"));
		j1.setGols(Integer.parseInt(JOptionPane.showInputDialog("Entre com numero de gols")));
		
		j2.setNome(JOptionPane.showInputDialog("Entre com o nome do jogador 2: "));
		j2.setNomeClube(JOptionPane.showInputDialog("Entre com o nome do clube"));
		j2.setGols(Integer.parseInt(JOptionPane.showInputDialog("Entre com numero de gols")));
		
		j3.setNome(JOptionPane.showInputDialog("Entre com o nome do jogador 3: "));
		j3.setNomeClube(JOptionPane.showInputDialog("Entre com o nome do clube"));
		j3.setGols(Integer.parseInt(JOptionPane.showInputDialog("Entre com numero de gols")));
		
		if(j1.getGols() > j2.getGols() && j1.getGols() > j3.getGols()){
			JOptionPane.showMessageDialog(null, "O jogador com mais gols é : "+j1.getNome());
		}
		else if(j2.getGols() > j1.getGols() && j2.getGols() > j3.getGols()){ 
			JOptionPane.showMessageDialog(null, "O jogador com mais gols é : "+j2.getNome());
		}
		else { 
			JOptionPane.showMessageDialog(null, "O jogador com mais gols é : "+j3.getNome());
		}
	}
}