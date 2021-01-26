package arraylistInverso;
import java.util.ArrayList;

public class Main {
		public static void main(String args[]) {
			ArrayList<String> lista = new ArrayList<>();
			lista.add("carlos");
			lista.add("marcelo");
			lista.add("diego");
			lista.add("marcos");
			for (int i=lista.size()-1;i>=0;i--){
				System.out.println(lista.get(i));
			}
	}
		
}
