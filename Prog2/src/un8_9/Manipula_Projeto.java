package un8_9;

import javax.swing.*;

import un7.Conexao;

import java.sql.*;
import java.util.Vector;

public class Manipula_Projeto {
  private Conexao MinhaConexao;
  
  public Manipula_Projeto(Conexao con){
	  setConexao(con);
  }
  
  public Manipula_Projeto(){
	  setConexao(null);
  }
  
  public void setConexao(Conexao con){MinhaConexao = con;}
  public Conexao getConexao(){return MinhaConexao;}
  
  //Regras de Negócio
  private String QuotedStr(String Item) {return "\'"+ Item + "\'";} 
  
  private String DataSQL(String Data) {
    return Data.substring(6)+'-'+Data.substring(3,5)+'-'+Data.substring(0,2); 
  }
  
  public void InsereDados(Projetos Proj){
	  if (Proj.getConsistencia()){
		String Colunas = "("+   Proj.getCampos().get(1)+","+
								Proj.getCampos().get(2)+","+
								Proj.getCampos().get(3)+","+
								Proj.getCampos().get(4)+","+
								Proj.getCampos().get(5)+")";
		String Valores = "("+
			             QuotedStr(Proj.getDescricao())+","+
		                 QuotedStr(DataSQL(Proj.getDataInicio()))+","+
		                 QuotedStr(DataSQL(Proj.getDataFinal()))+","+
		                 Proj.getPercentual()+","+
		                 QuotedStr(Proj.getSituacao())+")";

		if (consultaExisteRegistro(Proj.getIdProjeto()))
			AtualizarDados(Proj);
		else{
			String Comando = "Insert into Projetos"+Colunas + " values" +Valores;
			getConexao().ExpressaoSQL(Comando);
		}
	  }                    		
  }
  
  public void RemoverDados(int Codigo){
	  try{
	    getConexao().ExpressaoSQL("Delete from Projetos where idProjetos = " + Codigo);
	  }
	  catch(Exception sqle){
          JOptionPane.showMessageDialog(null,"Os dados não foram removidos!","",JOptionPane. WARNING_MESSAGE);
		  sqle.printStackTrace();
      }
  }

  
  public void RemoverDados(String Descricao){
	  try{
	    getConexao().ExpressaoSQL("Delete from Projetos where vDescricao = " + QuotedStr(Descricao));
	    getConexao().getCon().commit();
	  }
	  catch(Exception sqle){
		          JOptionPane.showMessageDialog(null,"Os dados não foram removidos!","",
                  JOptionPane. WARNING_MESSAGE);  
	  }
  }
  
  public void ListarDados(){
  	  boolean Listou = false;
	  try{
	    getConexao().ExpressaoSQL(" Select * from Projetos ");
	    ResultSet rs = getConexao().getDados();
	    if (rs != null){
	      while (rs.next()){
	      	Listou = true;
	        Projetos p = new Projetos();
	        int ID = rs.getInt("idProjetos"),
	            PERC = rs.getInt("nPercConcluido");	    
		    String DESC = rs.getString("vDescricao"),
		           SIT =rs.getString("vSituacao");
		    String DATAIN = rs.getString("dDataInicio"),
		           DATAFIN =  rs.getString("dDataFinal");
		    p.setIdProjeto(ID);
		    p.setDescricao(DESC);
		    p.setDataInicio(DATAIN);
		    p.setDataFinal(DATAFIN);
		    p.setPercentual(PERC);
		    p.setSituacao(SIT);
		    p.ShowDados();
	      }
	      if(!Listou)
	    	  JOptionPane.showMessageDialog(null,"Nenhum registro selecionado!","",
	                                             JOptionPane. WARNING_MESSAGE);  
	    }
	  }
	  catch(Exception sqle){
		          JOptionPane.showMessageDialog(null,"Os dados não foram listados!","",
                  JOptionPane. WARNING_MESSAGE);  
		  
	  }
  }
  
   
  
  public boolean consultaExisteRegistro(int Codigo){
  	 boolean existe = false;
	  try{
	    getConexao().ExpressaoSQL(" Select * from Projetos where IdProjetos = " + Codigo);
	    ResultSet rs = getConexao().getDados();
	    if (rs != null){
	      while (rs.next()){
	    	  existe = true;
	      }
	    }
	  } 
	  catch(Exception sqle){
	          sqle.printStackTrace();
	  }
	  return existe;
 }
	    
  
  
  public Projetos consultaDados(int Codigo){
  	  boolean Listou = false;
  	  Projetos p = null;
	  try{
	    getConexao().ExpressaoSQL(" Select * from Projetos where IdProjetos = " + Codigo);
	    ResultSet rs = getConexao().getDados();
	    if (rs != null){
	      while (rs.next()){
	      	Listou = true;
	        p = new Projetos();
	        int ID = rs.getInt("idProjetos"),
	            PERC = rs.getInt("nPercConcluido");	    
		    String DESC = rs.getString("vDescricao"),
		           SIT =rs.getString("vSituacao");
		    Date dti = rs.getDate("dDataInicio");
		    Date dtf = rs.getDate("dDataFinal");
		    p.setIdProjeto(ID);
		    p.setDescricao(DESC);
		    p.setDataInicio(dti.toString());
		    p.setDataFinal(dtf.toString());
		    p.setPercentual(PERC);
		    p.setSituacao(SIT);
	      }
	    }
	  }
	  catch(Exception sqle){
		   JOptionPane.showMessageDialog(null,"Os dados não foram listados!","", JOptionPane. WARNING_MESSAGE);  
		   sqle.printStackTrace();
	  }
	return p;
  }
  
  
  
  public void ListarDados(String Descricao){
  	  boolean Listou=false;
	  try{
	    getConexao().ExpressaoSQL(" Select * from Projetos where vDescricao = " + QuotedStr(Descricao));
	    ResultSet rs = getConexao().getDados();
	    if (rs != null){
	      while (rs.next()){
	      	Listou = true;
	        Projetos p = new Projetos();
	        int ID = rs.getInt("idProjetos"),
	            PERC = rs.getInt("nPercConcluido");	    
		    String DESC = rs.getString("vDescricao"),
		           SIT =rs.getString("vSituacao");
		    String DATAIN = rs.getString("dDataInicio"),
		           DATAFIN =  rs.getString("dDataFinal");
		    p.setIdProjeto(ID);
		    p.setDescricao(DESC);
		    p.setDataInicio(DATAIN);
		    p.setDataFinal(DATAFIN);
		    p.setPercentual(PERC);
		    p.setSituacao(SIT);
		    p.ShowDados();
	      }
	      if(!Listou)
	    	  JOptionPane.showMessageDialog(null,"Nenhum registro selecionado!","",
	                                             JOptionPane. WARNING_MESSAGE);  
	    }
	  }
	  catch(Exception sqle){
		          JOptionPane.showMessageDialog(null,"Os dados não foram listados!","",
                  JOptionPane. WARNING_MESSAGE);  
		  
	  }
  }
  
   
  
  public void AtualizarDados(Projetos p){
	  	String Comando = " Update Projetos set vDescricao="+QuotedStr(p.getDescricao())+",dDataInicio="+QuotedStr(DataSQL(p.getDataInicio()))+",dDataFinal="+QuotedStr(DataSQL(p.getDataFinal()))+
	  	",nPercConcluido="+p.getPercentual()+",vSituacao="+QuotedStr(p.getSituacao())+" where idProjetos = " + p.getIdProjeto();
	  	  
	   	try{
		    getConexao().ExpressaoSQL(Comando);
		}
		catch (Exception sqle)    {
			JOptionPane.showMessageDialog(null,"Os dados não foram atualizados!","",
	                                            JOptionPane. WARNING_MESSAGE);  
		}
   
}
  
}
