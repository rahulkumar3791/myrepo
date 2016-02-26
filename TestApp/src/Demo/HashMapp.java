package Demo;

import java.util.HashMap;
import java.util.Map;


public class HashMapp {
	
	public static void main(String[] args) {
		
		Map<String,String> map=new HashMap<String,String>();
		
		map.put("id", "123");
		map.put("name", "rahul");
		map.put("mob", "9717");
		map.put(null, "567");
		
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
		 
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("========== "+ value);
		}
	}

}
