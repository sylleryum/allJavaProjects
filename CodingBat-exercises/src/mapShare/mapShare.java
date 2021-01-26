package mapShare;

import java.util.HashMap;
import java.util.Map;

public class mapShare {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "carrot");
		map.put("d", "4");
		map.put("c", "3");

		// System.out.println("keySet: " +map.entrySet());

		// for (Map.Entry<String, String> m : map.entrySet()){
		// if ((m.getKey() == "a") && (m.getValue() != "")) {
		if (map.containsKey("c")){
			map.remove("c");
		}
		if (map.containsKey("a")) {
			if (map.get("a") != "") {
				map.put("b", map.get("a"));
				
			}
		}

		System.out.println(map.get("c"));

	}

}
