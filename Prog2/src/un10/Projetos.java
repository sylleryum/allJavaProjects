package un10;

import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;

public class Projetos {
  //Atributos da Classe	
  private int idProjeto;
  private String vDescricao;
  private String dDataInicio,dDataFinal;
  private int nPercentual;
  private String vSituacao;
  private boolean bConsistencia = true;
  
  public Projetos(){
	  setIdProjeto(0);
	  setDescricao("");
	  setDataInicio("");
	  setDataFinal("");
	  setPercentual(0);
	  setSituacao("Em aberto");
  }
  
  public Projetos(int idProjeto, String descricao, String dataInicio, String dataFinal, int percentual, String situacao){
	  setIdProjeto(idProjeto);
	  setDescricao(descricao);
	  setDataInicio(dataInicio);
	  setDataFinal(dataFinal);
	  setPercentual(percentual);
	  setSituacao(situacao);
  }
  
  public Projetos(String descricao, String dataInicio, String dataFinal, int percentual, String situacao){
	  setDescricao(descricao);
	  setDataInicio(dataInicio);
	  setDataFinal(dataFinal);
	  setPercentual(percentual);
	  setSituacao(situacao);
  }
  

 //Modificadores
 public void setIdProjeto(int idProjeto){
	 if (idProjeto >= 0) 
		 this.idProjeto = idProjeto;
	 else{
		 this.idProjeto = -1;
		 JOptionPane.showMessageDialog(null,"Código Incorreto.",
				                       "",JOptionPane. WARNING_MESSAGE);
		 setConsistencia(false);
		 return;
	 }	 
 }
 
 public void setDescricao(String descricao){
	 if (descricao.length() > 0) 
		 vDescricao = descricao;
	 else{
		 vDescricao = "Anônimo";
	     setConsistencia(false);
	     return;
	 }
}
 
 public void setDataInicio(String dataInicio){
	 if(DataCorreta(dataInicio))
			dDataInicio = dataInicio;
	 else{
		 DateFormat df = DateFormat.getDateInstance();
		 dDataInicio = df.format(new Date());
	 }
 }
 
 public void setDataFinal(String dataFinal){
	 if(DataCorreta(dataFinal))
			dDataFinal = dataFinal;
	 else{
		 DateFormat df = DateFormat.getDateInstance();
		 dDataFinal = df.format(new Date());
	 }
 }
 

 public void setPercentual(int percentual){
	 if(percentual >=0)
	   nPercentual = percentual;
	 else
	 {
	   nPercentual = 0;	 
	   JOptionPane.showMessageDialog(null,"Percentual Inválido.",
			                         "",JOptionPane. WARNING_MESSAGE);
	   setConsistencia(false);
	   return;
	 }  
 }
 
 public void setSituacao(String situacao) {
	 if (SituacaoCorreta(situacao))
	   vSituacao = situacao;
	 else{
		 vSituacao = "Em aberto";
		 JOptionPane.showMessageDialog(null,"Situação Inválida.",
                 "",JOptionPane. WARNING_MESSAGE); 
		 setConsistencia(false);
		 return;
	 } 
 }

 
 public void setConsistencia(boolean consistencia){
	 bConsistencia = consistencia;
 }
 
 //Recuperadores
 public String getDataFinal()
   {return dDataFinal;}
 public String getDataInicio() 
   {return dDataInicio;}
 public int getIdProjeto()
   {return idProjeto;} 
 public int getPercentual()
   {return nPercentual;}
 public String getDescricao()
   {return vDescricao;}
 public String getSituacao()
   {return vSituacao;}
 public boolean getConsistencia()
   {return bConsistencia;}
 
 //---- Regras de Negócio
 
 // Verifica se a data informada esta correta 
 private boolean DataCorreta(String Data){
    	 if (Data.substring(0,2).equals("/") && Data.substring(3,5).equals("/")){
    		 return true;
    	 }
    	 else{
    		 JOptionPane.showMessageDialog(null,"Formato de data incorreto!" + Data,"",JOptionPane. WARNING_MESSAGE);
    		 return false;
    	 }	 
 }

 
 // Verifica se a situação esta dentro das opções válidas
 private boolean SituacaoCorreta(String opcao){
	Vector  opcoes = new Vector();
	opcoes.add("FINALIZADO");
	opcoes.add("EM ABERTO");
	opcoes.add("EM EXECUÇÃO");
	return opcoes.contains(opcao.toUpperCase());
 }
 
 
 
 // Apresenta os dados cadastrados no Projeto
 
 public void ShowDados(){
	 String Saida = "Projeto        :"+getIdProjeto()+
	                "\n Descricao   :"+getDescricao()+
	                "\n Iniciado em :"+getDataInicio()+
	                "\n Encerrado em:"+getDataFinal()+
	                "\n Concluídos  :"+ getPercentual()+"%" +
	                "\n Situação    :"+getSituacao();
	 JOptionPane.showMessageDialog(null,Saida);
 }
 
 public Vector getCampos(){
	 Vector Campos = new Vector();
	 Campos.add("idProjetos");
	 Campos.add("vDescricao");
	 Campos.add("dDataInicio");
	 Campos.add("dDataFinal");
	 Campos.add("nPercConcluido");
	 Campos.add("vSituacao");
	 return Campos;
 }
   
  
}
