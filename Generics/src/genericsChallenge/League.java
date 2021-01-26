package genericsChallenge;
import java.util.ArrayList;

public class League<T extends Team>{
	private String nome;
	
	public League (String nome){
		this.nome = nome;		
	}
	private ArrayList<T> league = new ArrayList<>();

	public void addTeam (T team){
		league.add(team);
	}

}
