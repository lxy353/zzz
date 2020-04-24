import java.util.HashMap;



public class HashSet {
	    HashMap map;
	    private  static final Object RESENT = new Object();
	public static void main(String [] args){
		HashSet set = new HashSet();
		set.add("aaaa");
		set.add("bbb");
		set.add("cccc");
		
	}
	@Override
	public String toString() {
	// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[");
		for (Object key:map.keySet()) {
			sBuilder.append(key+",");
		}
			
		sBuilder.setCharAt(sBuilder.length()-1, '}');
	return super.toString();
	}
	
		public HashSet() {
			map = new HashMap();
			
		}
		public int siez() {
			return map.size();
		}
		
	  public void add(Object o) {
		  map.put(0, RESENT);
	  }
		
	}


