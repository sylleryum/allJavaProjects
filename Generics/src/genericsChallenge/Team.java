package genericsChallenge;

public class Team implements Comparable<Team>{

	private String nome;
	private int pontos;
	
	public Team(String nome, int pontos){
		this.nome = nome;
		this.pontos = pontos;
	}
		
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public int compareTo(Team outroTime) {
		if (this.pontos < outroTime.pontos) {
            return -1;
        }
        if (this.pontos > outroTime.pontos) {
            return 1;
        }
        return 0;
	}
	
}
