package countHi;

public class CountHi {

	public static void main(String[] args) {
		//Return the number of times that the string "hi" appears anywhere in the given string.
		System.out.println("resultado: "+hiCount("hhhilhi"));
		
	}
	
	public static int hiCount (String str){
		int count=0;
		for(int i=1;i<str.length();i++){
			if (str.charAt(i)=='i' && str.charAt(i-1)=='h'){
				count +=1;
			}
		}
		
		return count;
	}

}
