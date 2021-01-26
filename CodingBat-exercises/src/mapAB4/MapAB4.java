package mapAB4;

import java.lang.Math;

import java.util.HashMap;
import java.util.Map;

public class MapAB4 {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		// System.out.println("keySet: " +map.entrySet());

		if (map.containsKey("a") && (map.containsKey("b"))){
			
			if ((map.get("a").length()) != (map.get("b").length())) {

				if (map.get("a").length() > map.get("b").length()) {
					map.put("c", map.get("a"));
				} else if (map.get("a").length() < map.get("b").length()) {
					map.put("c", map.get("b"));
				}
			} else if((map.get("a").length()) == (map.get("b").length())) {
				map.put("a", "");
				map.put("b", "");
			}
		
		}
		
		System.out.println(map.entrySet());

	}

}
