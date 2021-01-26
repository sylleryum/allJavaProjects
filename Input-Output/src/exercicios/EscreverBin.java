package exercicios;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import binary.Location;

public class EscreverBin {

//	try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//        for (Location location : locations.values()) {
//            locFile.writeInt(location.getLocationID());
//            locFile.writeUTF(location.getDescription());
//            System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
//            System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
//            locFile.writeInt(location.getExits().size() - 1);
//            for (String direction : location.getExits().keySet()) {
//                if (!direction.equalsIgnoreCase("Q")) {
//                    System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
//                    locFile.writeUTF(direction);
//                    locFile.writeInt(location.getExits().get(direction));
//                }
//            }
//        }
//    }
		
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list.add("car");
		list1.add(3);
		list.add("art");
		list1.add(4);
		list.add("man");	
		list1.add(5);
		list.add("sen");
		list1.add(6);
		list.add("bio");
		list1.add(7);
		list.add("bae");
		
		
		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("lerBin.dat")))){
			for(int i=0;i<list.size();i++){
				out.writeInt(list1.get(i));
				out.writeUTF(list.get(i));				
			}

		} catch (IOException e) {			
			e.printStackTrace();
		} 
	}
}
