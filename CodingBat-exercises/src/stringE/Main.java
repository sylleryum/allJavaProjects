package stringE;


public class Main {	
	public static void main(String[] args) {
		String str = "e";

		int cont = 0;		
		System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e') {
				cont++;
			}
		}
		if (cont >= 1 && cont <= 3) {
			System.out.println("cont1: " + cont);
		} else {
			System.out.println("cont2: " + cont);
		}
	}
}
