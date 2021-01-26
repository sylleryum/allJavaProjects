package close10;

import java.lang.Math;

public class close10 {
	public static void main(String[] args) {
		int a = 7;
		int b = 13;

		int contA = 1;
		int contB = 1;

		if (a <= 10){
			for (int i=a;i<10;i++){
				contA++;
			}
		} else if(a >= 10){
			for (int i=a;i>10;i--){
				contA++;
			}
		}
		//
		if (b <= 10){
			for (int i=b;i<10;i++){
				contB++;
			}
		} else if(b >= 10){
			for (int i=b;i>10;i--){
				contB++;
			}
		}		
		System.out.println("var"+contA +" "+ contB);
		if (contA<contB){
			System.out.println("contA: "+a);
		}else if(contA>contB){
			System.out.println("contB: "+b); 
		}else if (contA==contB){
			System.out.println("equal");
		}
	}

}