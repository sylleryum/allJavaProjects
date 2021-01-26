package linkedHashset;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	//rooms above 40 = R$ 50
	//rooms between 11 and 40 = R$ 30
	//rooms below 11 = R$ 25
	public static void main(String[] args) {				
		Scanner read = new Scanner(System.in);		
		Rooms room = new Rooms();
		int opcao;
			
		
		do {
			opcoes();
			opcao = read.nextInt();
			int quarto;
			if (opcao == 1){
				System.out.println("digite o numero do quarto: ");
				quarto = read.nextInt();
				if (room.roomList.get(quarto).getAvailable()){
					room.roomList.get(quarto).setAvailable(false);
					System.out.println("Reservado com sucesso!");
				} else {
					System.out.println("Quarto já reservado!");
				}
				
				
			}else if (opcao ==2){
				System.out.println("digite o numero do quarto: ");
				quarto = read.nextInt();
				if (!room.roomList.get(quarto).getAvailable()){
					room.roomList.get(quarto).setAvailable(true);
					System.out.println("Check out feito com sucesso!");
				} else {
					System.out.println("Quarto não ocupado!");
				}
			}
			
			
			else if (opcao == 3){
				for (Map.Entry<Integer, Rooms> r : room.roomList.entrySet()){
					System.out.println("\t"+r.getKey() +" R$ "+r.getValue().getPrice()+"|| Disp: "
							+(r.getValue().getAvailable()?"Disponivel":"indisponivel"));
				}
			}
		} while (opcao!=4);
		
		
		
		
	}
	
	static void opcoes(){
		System.out.println("Pressione 1 para ocupar quarto");		
		System.out.println("Pressione 2 para dar checkout no quarto");
		System.out.println("Pressione 3 para ver quartos livres");
		System.out.println("Pressione 4 para sair");
	}
	
}
