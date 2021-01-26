package palindromo;

public class Main {

	public static void main(String[] args) {

		String p1 = "dracula";
		String p2 = "alucard";

		if (p1.length() == p2.length()) {
			int j = p2.length() - 1;
			for (int i = 0; i < p1.length(); i++) {
				System.out.println("i " + i);				
				char s = p1.charAt(i);
				if (s == p2.charAt(j)) {
					System.out.println("j "+j);
					
					System.out.println("= "+i+" = "+j);
					if(i==p1.length()-1 && j==0){
						System.out.println("true!");
					}
					j--;

				} else {
					System.out.println("é false");
					break;
				}

				// for (int j = (p2.length() - 1); j >= 0; j--) {
				// System.out.println("j " + j);
				//
				// }
			}
		} else {
			System.out.println("falso");
		}

	}

}
