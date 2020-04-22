import javax.xml.transform.Templates;

/**
 * 自定义一个HashMap
 *tostring
 * @author 高淇
 *
 */
public class HashMap2 {
	
	Node[]  table;    //位桶数组。bucket  array
	int size;				//存放的键值对的个数
	
	public HashMap2() {
		table = new Node[16];    //长度一般定义成2的整数幂
	}
    @Override
    public String toString() {
    	StringBuilder sBuilder = new StringBuilder("{") ;
    	for (int i = 0; i < table.length; i++) {
			Node teNode = table[i];
			while (teNode!=null) {
				sBuilder.append(teNode.keyObject+":"+teNode.valueObject+",");
				teNode = teNode .next;
				
			}
			
		}
    	sBuilder.setCharAt(sBuilder.length()-1, '}');
    	return sBuilder.toString();
    }
	public  void   put(Object key,  Object   value){
		//定义了新的节点对象
		Node    newNode = new Node();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.keyObject =  key;
		newNode.valueObject = value;
		newNode.next = null;
		
		Node temp = table[newNode.hash];
		
		Node  iterLast = null;  //正在遍历的最后一个元素
		boolean  keyRepeat = false;  
		if(temp==null){
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
		}else{
			//此处数组元素不为空。则遍历对应链表。。
			while(temp!=null){
				//判断key如果重复，则覆盖
				if(temp.keyObject.equals(key)){
					keyRepeat = true;
					temp.valueObject =  value;  //只是覆盖value即可。其他的值(hash,key,next)保持不变。
					break;		
				}else{
					//key不重复，则遍历下一个。
					iterLast = temp;
					temp = temp.next;					
				}
			}			
			if(!keyRepeat){   //没有发生key重复的情况，则添加到链表最后。
				iterLast.next = newNode;
			}	
		}
	}

	public static void main(String[] args) {
		HashMap2  m = new HashMap2();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");
		
		
		System.out.println(m);

//		for(int i=10;i<100;i++){
//			System.out.println(i+"---"+myHash(i,16));   //53, 69,85
//		}
		
	}
	
	
	public static  int  myHash(int  v, int length){
//		System.out.println("hash in myHash:"+(v&(length-1)));		//直接位运算，效率高
//		System.out.println("hash in myHash:"+(v%(length-1)));		//取模运算，效率低
		return  v&(length-1);
	}
	
	
}

