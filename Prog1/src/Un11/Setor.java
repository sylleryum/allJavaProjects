package Un11;
public class Setor {
	private int codigo;
	private String nomesetor;
	
	public Setor( ){
		codigo=0;
		nomesetor="";
	}
	
	public Setor(int icod, String snomeset ){
		codigo=icod;
		nomesetor=snomeset;
	}
	public void setCodigo(int icod){
		codigo=icod;
	}
	
	public void setNomeSetor(String snomeset){
		nomesetor= snomeset;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public String getNomeSetor(){
		return nomesetor;
	}
	

}
