package exercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import text.Location;

public class LerTxt2 {

//	try {
//        scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
//        scanner.useDelimiter(",");
//        while(scanner.hasNextLine()) {
////            int loc = scanner.nextInt();
////            scanner.skip(scanner.delimiter());
////            String direction = scanner.next();
////            scanner.skip(scanner.delimiter());
////            String dest = scanner.nextLine();
////            int destination = Integer.parseInt(dest);
//            String input = scanner.nextLine();
//            String[] data = input.split(",");
//            int loc = Integer.parseInt(data[0]);
//            String direction = data[1];
//            int destination = Integer.parseInt(data[2]);
//
//            System.out.println(loc + ": " + direction + ": " + destination);
//            Location location = locations.get(loc);
//            location.addExit(direction, destination);
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    } finally {
//        if(scanner != null) {
//            scanner.close();
//        }
//    }
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(new BufferedReader(new FileReader("ler1.txt")))){
			while (scan.hasNextLine()){
				String temp = scan.nextLine();
				String[] str = temp.split(";");
				int n1 = Integer.parseInt(str[0]);
				String s1 = str[1];
				int n2 = Integer.parseInt(str[2]);
				System.out.println("linha: " + n1 + " - " + s1 + " - " + n2);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
