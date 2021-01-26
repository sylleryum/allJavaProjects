package AD2Q4;
import javax.swing.*;
public class Paciente {
	private String nome, sexo;
	private int idade;
	private Medico medico;
	private Doenca doenca;
	
	
	public Paciente() {
		this.nome = "";
		this.sexo = "";
		this.idade = 0;
		this.medico = null;
		this.doenca = null;
	}
	//set
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public void setDoenca(Doenca doenca) {
		this.doenca = doenca;
	}

	//get
	
	public String getNome() {
		return nome;
	}
	public String getSexo() {
		return sexo;
	}
	public int getIdade() {
		return idade;
	}
	public Medico getMedico() {
		return medico;
	}
	public Doenca getDoenca() {
		return doenca;
	}
	
	public void listar(){
		JOptionPane.showMessageDialog
		(null, "Nome:" + nome + "\n"
			 + "Idade:" + idade + "\n"
			 + "Sexo:" + sexo + "\n");
	}
 
}