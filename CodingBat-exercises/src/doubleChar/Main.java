package doubleChar;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Resultado: "+doubleStr("teste"));
	}
	
	public static String doubleStr (String str){
		
		StringBuilder builder = new StringBuilder();
			for(int i=0;i<str.length();i++){
				builder.append(str.charAt(i)).append(str.charAt(i));
				
			}
		
		
		return String.valueOf(builder);
	}

}
