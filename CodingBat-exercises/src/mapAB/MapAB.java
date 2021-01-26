package mapAB;

import java.util.HashMap;
import java.util.Map;

public class MapAB {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaa");
		map.put("ab", "nope");
		map.put("b", "bbb");		
		map.put("c", "ccc");
		// System.out.println("keySet: " +map.entrySet());

		if (map.containsKey("a") && (map.containsKey("b"))){
			if (map.containsKey("ab")){
				map.put("ab", (map.get("a")+map.get("b")));
			} else if(!map.containsKey("ab")){
				map.put("ab", (map.get("a")+map.get("b")));
			}
		}

		System.out.println(map.entrySet());

	}

}
