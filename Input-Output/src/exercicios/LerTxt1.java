package exercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import binary.Location;

public class LerTxt1 {

	// try(Scanner scanner = new Scanner(new BufferedReader(new
	// FileReader("locations_big.txt")))) {
	// scanner.useDelimiter(",");
	// while(scanner.hasNextLine()) {
	// int loc = scanner.nextInt();
	// scanner.skip(scanner.delimiter());
	// String description = scanner.nextLine();
	// System.out.println("Imported loc: " + loc + ": " + description);
	// Map<String, Integer> tempExit = new HashMap<>();
	// locations.put(loc, new Location(loc, description, tempExit));
	// }
	//
	// } catch(IOException e) {
	// e.printStackTrace();
	// }
	//
	// // Now read the exits
	// try (BufferedReader dirFile = new BufferedReader(new
	// FileReader("directions_big.txt"))) {
	// String input;
	// while((input = dirFile.readLine()) != null) {
	// String[] data = input.split(",");
	// int loc = Integer.parseInt(data[0]);
	// String direction = data[1];
	// int destination = Integer.parseInt(data[2]);
	//
	// System.out.println(loc + ": " + direction + ": " + destination);
	// Location location = locations.get(loc);
	// location.addExit(direction, destination);
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new FileReader("ler1.txt")))) {
			scan.useDelimiter(";");
			while (scan.hasNextLine()) {
				int n1 = scan.nextInt();
				scan.skip(scan.delimiter());
				String s1 = scan.next();
				scan.skip(scan.delimiter());
				int n2 = Integer.parseInt(scan.nextLine());
				System.out.println("linha: " + n1 + " - " + s1 + " - " + n2);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
