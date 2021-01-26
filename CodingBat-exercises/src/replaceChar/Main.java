package replaceChar;

public class Main {

	public static void main(String[] args) {
		
		String r = replace("ovo",3);
		System.out.println("resultado "+r);
		
	}
	
	public static String replace(String str, int pos){
		char[] c = str.toCharArray();
		c[pos-1] = 'N';
		for(int i=0;i<3;i++){
			System.out.println(c[i]);
		}
		//for(1>3)
		return String.valueOf(c);
		
	}

}
