package word0.map;

import java.util.HashMap;
import java.util.Map;

public class word0 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
				
		String[] str = {"c", "c", "c"};
		for (int i=1;i<str.length;i++){
			map.put(str[0], 0);
			for (int j=str.length-1;j>=0;j--){				
				if (!str[i].equalsIgnoreCase(str[j])){
					map.put(str[i], 0);
				}
					
			}
		}
		
		for (Map.Entry<String, Integer> m : map.entrySet()){
			System.out.println("print: "+m);
			
		}

	}

}
