package empresa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class EmMain {

	public static void main(String[] args) {
		List<Gerente> listaG = new ArrayList<Gerente>();
		boolean continuar = true;
		while (continuar) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("1-incluir \n2-gerente=regiao\n"));
			if (opcao == 1) {
				Gerente ger = new Gerente();
				ger.setNome(JOptionPane.showInputDialog("Nome: "));
				ger.setRegiao(JOptionPane.showInputDialog("Regiao: "));
				ger.setSalario(Double.parseDouble(JOptionPane.showInputDialog("salario: ")));
				listaG.add(ger);
				JOptionPane.showMessageDialog(null, "Incluido com sucesso!");
			}
			if (opcao == 2) {
				String buscaG = JOptionPane.showInputDialog("busca Gerente: ");
				for (Gerente ger : listaG) {
					if (buscaG.equalsIgnoreCase(ger.getNome())){
						JOptionPane.showMessageDialog(null, "R regiao: " +ger.getRegiao());
						JOptionPane.showMessageDialog(null, "R salario: " +ger.getSalario());
					}
				}
			}
		}

	}
}