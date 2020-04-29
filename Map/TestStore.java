import java.util.*;

public class TestStore {
	public static void main(String[] args) {
		Map<String, Object> rowMap1 = new HashMap<String,Object>();
		rowMap1.put("id", 1001);
		rowMap1.put("name", "lxy");
		rowMap1.put("income", 2001);
		rowMap1.put("day", "2018.11.11");
		
		Map<String, Object> rowMap2 = new HashMap<String,Object>();
		rowMap2.put("id", 1002);
		rowMap2.put("name", "lxly");
		rowMap2.put("income", 2002);
		rowMap2.put("day", "2018.12.11");
		
		List<Map<String, Object>> tableList = new ArrayList<Map<String,Object>>();
		
		tableList.add(rowMap1);
		tableList.add(rowMap2);
		
		for(Map<String, Object> rowMap:tableList) {
			Set<String>keySet = rowMap.keySet();
			for(String key:keySet) {
				System.out.print(key + ":"+ rowMap.get(key));
			}
			System.out.println();
		}
		
		
	}

}
