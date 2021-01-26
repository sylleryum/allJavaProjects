package linkedHashset;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Rooms {
	private int roomNum;
	private boolean available = true;
	private double price;
	Map<Integer, Rooms> roomList = new HashMap<>();
	
	public Rooms(int roomNum, double price) {
		this.roomNum = roomNum;
		this.price = price;
		
	}
	
	public Rooms (){
		for (int i=1;i<=50;i++){			
			if (i < 11){
				roomList.put(i, (new Rooms(i, 25)));
			} else if (i>10 && i<41){
				roomList.put(i, (new Rooms(i, 30)));
			} else if (i>40){
				roomList.put(i, (new Rooms(i, 50)));
			}
		}
	}
	

	public int getRoomNum() {
		return roomNum;
	}

	
	
	
	public boolean getAvailable() {
		return available;
	}

	public double getPrice() {
		return price;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
