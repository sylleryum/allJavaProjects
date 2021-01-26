package palindromo;

public class Main2 {

	public static void main(String[] args) {
		
		String s1 = "dracull";
		String s2 = "alucard";
		System.out.println(pal(s1,s2));
	}
	
	public static boolean pal(String s1, String s2){
		
		if(s1.length()==s2.length()){
			int i=0;
			int j=s2.length()-1;
			while(i<s1.length() && j>-1){
				System.out.println(i+" "+j);
				if(s1.charAt(i)!=s2.charAt(j)){
					System.out.println("Falso i= "+s1.charAt(i)+" j= "+s2.charAt(j));
					return false;					
				} else{
					System.out.println("true i= "+s1.charAt(i)+" j= "+s2.charAt(j));
					
				}
				
				i++;
				j--;
			}return true;			
			
		}else{
			return false;
		}

	}

}
