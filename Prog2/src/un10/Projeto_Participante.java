package un10;

import javax.swing.JOptionPane;

public class Projeto_Participante {
	private int idProjeto;
	private int idParticipante;
	private boolean bConsistencia;
	
	public Projeto_Participante(){
		setIdProjeto(1);
		setIdParticipante(1);
		setConsistencia(false);
	}
	
	public void setIdProjeto(int idProjeto){
		 if (idProjeto > 0) 
			 this.idProjeto = idProjeto;
		 else{
			 this.idProjeto = 1;
			 JOptionPane.showMessageDialog(null,"Código Incorreto.",
					                       "",JOptionPane. WARNING_MESSAGE);
			 setConsistencia(false);
			 return;
		 }	 
		 setConsistencia(true);
	 }
	
	public void setIdParticipante(int idParticipante){
		 if (idParticipante > 0) 
			 this.idParticipante = idParticipante;
		 else{
			 this.idParticipante = 1;
			 JOptionPane.showMessageDialog(null,"Código Incorreto.",
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
	 public int getIdProjeto()
	   {return this.idProjeto;}
	 public int getIdParticipante()
	   {return this.idParticipante;} 
	 public boolean getConsistencia()
	   {return bConsistencia;}
	 
}
