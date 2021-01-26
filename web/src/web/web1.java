package web;
import javax.swing.*;
class DadosProfessor {
public static void main(String args[])
{
String NOME, ENDERECO, CIDADE, ESTADO, CEP, DATANASC, GRAUESC, CURSO;
int RG;
NOME =JOptionPane.showInputDialog("Entre com o Nome");
ENDERECO = JOptionPane.showInputDialog("Entre com o Endereço");
CIDADE = JOptionPane.showInputDialog("Entre com a Cidade");
ESTADO = JOptionPane.showInputDialog("Entre com o Estado");
CEP = JOptionPane.showInputDialog("Entre com o CEP");
RG = Integer.parseInt(JOptionPane.showInputDialog("Entre com o RG"));
DATANASC = JOptionPane.showInputDialog("Entre com a Data de Nascimento");
GRAUESC = JOptionPane.showInputDialog("Entre com o Grau de Escolaridade");
CURSO = JOptionPane.showInputDialog("Entre com o Curso");
JOptionPane.showMessageDialog(null,"Nome " + NOME);
JOptionPane.showMessageDialog(null,"Endereço " + ENDERECO);
JOptionPane.showMessageDialog(null,"Cidade " + CIDADE);
JOptionPane.showMessageDialog(null,"Estado " + ESTADO);
JOptionPane.showMessageDialog(null,"CEP " + CEP);
JOptionPane.showMessageDialog(null,"RG " + RG);
JOptionPane.showMessageDialog(null,"Data de Nascimento " + DATANASC);
JOptionPane.showMessageDialog(null,"Grau de Escolaridade " + GRAUESC);
JOptionPane.showMessageDialog(null,"Curso " + CURSO);
System.exit(0);
}
}