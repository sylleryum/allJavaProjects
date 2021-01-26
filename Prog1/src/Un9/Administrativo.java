package Un9;
public class Administrativo extends Funcionario{
	private String cargo, setor;
	
	public Administrativo ( ){
		super( );
		cargo = "";
		setor = "";
	}
	
	public void setSalario(double dsalario){
		if (cargo.equalsIgnoreCase("Tecnico Administrativo"))
			super.setSalario(dsalario+(300));
		else if (cargo.equalsIgnoreCase("Bibliotecaria"))
			super.setSalario(dsalario+(400));
		else
			super.setSalario(dsalario+(500));
	}
	
	public void setCargo(String scargo){
		cargo=scargo;
	}
	public String getCargo(){
		return cargo;
	}
	public void setSetor(String ssetor){
		setor=ssetor;
	}
	public String getSetor(){
		return setor;
	}
}