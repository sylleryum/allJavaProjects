package topping1;

import java.util.HashMap;
import java.util.Map;

public class topping1 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaa");
		map.put("bread", "fruit");
		map.put("ice cream", "bbb");		
		map.put("c", "ccc");
		// System.out.println("keySet: " +map.entrySet());
//		if (map.containsKey("bread")){
//			map.put("bread", "butter");
//		} else if (!map.containsKey("bread")){
//			map.put("bread", "butter");
//		}
		map.put("bread", "butter");

		if (map.containsKey("ice cream")){
			map.put("ice cream", "cherry");
		}

		System.out.println(map.entrySet());

	}

}
