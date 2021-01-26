package un10;

import java.util.*;
import javax.swing.JOptionPane;

public class Participantes {
  //Atributos da Classe	
  private int idParticipante;
  private String vNome;
  private String vCargo;
  private boolean bConsistencia;
  
  public Participantes(){
	  setIdParticipante(1);
	  setNome("");
	  setCargo("Gerente");
	  setConsistencia(false);
  }

 //Modificadores
 public void setIdParticipante(int idParticipante){
	 if (idParticipante > 0) 
		 this.idParticipante = idParticipante;
	 else{
		 this.idParticipante = 1;
		 JOptionPane.showMessageDialog(null,"C�digo Incorreto.",
				                       "",JOptionPane. WARNING_MESSAGE);
		 setConsistencia(false);
		 return;
	 }	 
	 setConsistencia(true);
 }
 
 public void setNome(String nome){
	 if (nome.length() > 0) 
		 vNome = nome;
	 else{
		 vNome = "An�nimo";
	     setConsistencia(false);
	     return;
	 }
	 setConsistencia(true);
 }
 
 public void setCargo(String cargo) {
	 if (CargoCorreto(cargo))
	   vCargo = cargo;
	 else{
		 vCargo = "Inv�lido";
		 JOptionPane.showMessageDialog(null,"Cargo Inv�lido.",
                 "",JOptionPane. WARNING_MESSAGE); 
		 setConsistencia(false);
		 return;
	 } 
	 setConsistencia(true);
 }
 
 public void setConsistencia(boolean consistencia){
	 bConsistencia = consistencia;
 }
 
 //Recuperadores
 public String getCargo()
   {return vCargo;}
 public String getNome() 
   {return vNome;}
 public int getIdParticipante()
   {return this.idParticipante;} 
 public boolean getConsistencia()
   {return bConsistencia;}
 
 //---- Regras de Neg�cio
 
 // Verifica se a situa��o esta dentro das op��es v�lidas
 private boolean CargoCorreto(String cargo){
	Vector  cargos = new Vector();
	cargos.add("GERENTE");
	cargos.add("PROGRAMADOR");
	cargos.add("ANALISTA DE SISTEMAS");
	cargos.add("DBA");
	return cargos.contains(cargo.toUpperCase());
 }
 
 // Realiza o cadastro dos dados do Projeto
 public void LeiaDados(){
	 setIdParticipante(Integer.parseInt(JOptionPane.showInputDialog("C�digo do Participante")));
	 if (getConsistencia())
	   setNome(JOptionPane.showInputDialog("Nome"));
	 if (getConsistencia())
	   setCargo(JOptionPane.showInputDialog("cargo"));
	 if (!getConsistencia())
		 JOptionPane.showMessageDialog(null,"Os dados n�o foram lidos!","",
				                             JOptionPane. WARNING_MESSAGE);
 }
 
 public void LeiaDados(boolean AUTO){
     setNome(JOptionPane.showInputDialog("Nome"));
	 if (getConsistencia())
	   setCargo(JOptionPane.showInputDialog("cargo"));
	 if (!getConsistencia())
		 JOptionPane.showMessageDialog(null,"Os dados n�o foram lidos!","",
				                             JOptionPane. WARNING_MESSAGE); 
 }

 // Apresenta os dados cadastrados no Projeto
 
 public void ShowDados(){
	 String Saida = "Projetista     :"+getIdParticipante()+
	                "\n Nome   :"+getNome()+
	                "\n Cargo  :"+getCargo();
	 JOptionPane.showMessageDialog(null,Saida);
	 
 }
   
  
}
