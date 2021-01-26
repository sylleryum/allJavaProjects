package exercicios;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import binary.Location;

public class LerBin {

//	try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//        boolean eof = false;
//        while(!eof) {
//            try {
//                Map<String, Integer> exits = new LinkedHashMap<>();
//                int locID = locFile.readInt();
//                String description = locFile.readUTF();
//                int numExits = locFile.readInt();
//                System.out.println("Read location " + locID + " : " + description);
//                System.out.println("Found " + numExits + " exits");
//                for(int i=0; i<numExits; i++) {
//                    String direction = locFile.readUTF();
//                    int destination = locFile.readInt();
//                    exits.put(direction, destination);
//                    System.out.println("\t\t" + direction + "," + destination);
//                }
//                locations.put(locID, new Location(locID, description, exits));
//
//            } catch(EOFException e) {
//                eof = true;
//            }
//
//        }
//    } catch(IOException io) {
//        System.out.println("IO Exception");
//    }

	
	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();		
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("lerBin.dat")))) {
			Boolean fim = false;			
			while (!fim) {
				try{	
					list1.add(in.readInt());
					list.add(in.readUTF());
				} catch (EOFException e) {
					fim = true;
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}

		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
			System.out.println(list.get(i));
		}

	}

}
