package empresa;
public class Funcionario {
	protected int cod;
	protected double salario;
	protected String nome;

	// construtor
	public Funcionario() {
		this.cod = 0;
		this.salario = 0;
		this.nome = "";
	}

	public Funcionario(int cod, double salario, String nome) {
		this.cod = cod;
		this.salario = salario;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public double getSalario() {
		return salario;
	}

	public String getNome() {
		return nome;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
