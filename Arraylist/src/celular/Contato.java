package celular;
public class Contato {
  private int cel;
  private String nome;
  
  public Contato(){
    this.cel = 0;
    this.nome = "";
  }
  
  public Contato(String nome, int cel){
    this.cel = cel;
    this.nome = nome;
  }
  
  public void setCel (int cel){
    this.cel = cel;
  }
  
  public void setNome (String nome){
    this.nome = nome;
  }
  
  public int getCel (){
    return cel;
  }
  
  public String getNome (){
    return nome;
  }
  
}