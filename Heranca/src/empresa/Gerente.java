package empresa;

public class Gerente extends Funcionario {
	private int qtde_funcionarios;
	private String regiao;

	// construtor overload
	public Gerente(int qtde_funcionarios, String regiao) {
		super();
		this.qtde_funcionarios = qtde_funcionarios;
		this.regiao = regiao;
	}

	// construtor
	public Gerente() {
		super();
		this.qtde_funcionarios = 0;
		this.regiao = "";
	}

	/////////
	@Override
	public void setSalario(double ssalario) {
		if (qtde_funcionarios>50){
			salario = ssalario + (ssalario * 0.10);
		}
		if (regiao=="shopping"){
			salario = ssalario + (ssalario * 0.05);
		}
		else{
			salario = ssalario;
		}
	}

	public int getQtde_funcionarios() {
		return qtde_funcionarios;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setQtde_funcionarios(int qtde_funcionarios) {
		this.qtde_funcionarios = qtde_funcionarios;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
}
