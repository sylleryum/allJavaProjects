package genericsChallenge;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
	Team time1 = new Team("time1", 5);
	Team time2 = new Team("time2", 4);
	Team time3 = new Team("time3", 2);
	Team time4 = new Team("time4", 7);
	Team time5 = new Team("time5", 1);
	Team time6 = new Team("time6", 9);
	
	
	ArrayList<Team> time = new ArrayList<Team>();
	time.add(time1);
	time.add(time2);
	time.add(time3);
	time.add(time4);
	time.add(time5);
	time.add(time6);
	Collections.sort(time);

	for (int i=0;i<=5;i++){
		System.out.println(time.get(i).getNome()+" "+time.get(i).getPontos());
	}
	
	}
}
