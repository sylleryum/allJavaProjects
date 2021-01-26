package getSandwich;

import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// A sandwich is two pieces of bread with something in between.
		// Return the string that is between the first and last appearance of
		// "bread"
		// in the given string, or return the empty string "" if there are not
		// two pieces of bread.
		System.out.println("="+sandwich("breadbreadbreadbread")+"=");


	}

	public static String sandwich(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'r' && str.charAt(i + 2) == 'e' && str.charAt(i + 3) == 'a'
					&& str.charAt(i + 4) == 'd') {
				
				str = str.substring(i + 5);
				i = 0;
				for (int j=str.length()-1;j>0;j--){
					if (str.charAt(j) == 'd' && str.charAt(j - 1) == 'a' && str.charAt(j - 2) == 'e' && str.charAt(j - 3) == 'r'
							&& str.charAt(j - 4) == 'b'){
						return str = str.substring(0, j-4);
					}
					
				}
				//System.out.println("9090 "+str+i);
			}/* else if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'r' && str.charAt(i + 2) == 'e'
					&& str.charAt(i + 3) == 'a' && str.charAt(i + 4) == 'd' && check == true) {
				//System.out.println("88888 "+str+i);
				return str = str.substring(0, i);
			} else if (str.equalsIgnoreCase("bread")){
				return "";
			}
*/
		}
		return "";

	}

}
