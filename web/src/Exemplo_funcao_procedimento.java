import javax.swing.*;
public class Exemplo_funcao_procedimento {
	public static void main(String args[]){
		int n1,n2, resultado;
		String mensagem;
		n1=Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero 1"));
		n2=Integer.parseInt(JOptionPane.showInputDialog("Entre com o Numero 2"));
		resultado = soma (n1,n2);
		mensagem = JOptionPane.showInputDialog("Entre com a mensagem");
		imprime(mensagem, resultado);
}
	

	public static int soma(int n1, int n2)
	{
		return n1 + n2;
	}

	public static void imprime(String leg, int valor)
	{
		JOptionPane.showMessageDialog(null, leg + valor);
	}
}