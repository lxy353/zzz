import javax.xml.transform.Templates;

/**
 * �Զ���һ��HashMap
 *tostring
 * @author ���
 *
 */
public class HashMap4<K,V> {
	
	Node2[]  table;    //λͰ���顣bucket  array
	int size;				//��ŵļ�ֵ�Եĸ���
	
	public HashMap4() {
		table = new Node2[16];    //����һ�㶨���2��������
	}
    @Override
    public String toString() {
    	StringBuilder sBuilder = new StringBuilder("{") ;
    	for (int i = 0; i < table.length; i++) {
			Node2 teNode = table[i];
			while (teNode!=null) {
				sBuilder.append(teNode.keyObject+":"+teNode.valueObject+",");
				teNode = teNode .next;
				
			}
			
		}
    	sBuilder.setCharAt(sBuilder.length()-1, '}');
    	return sBuilder.toString();
    }
    public V get(K keyObject) {
    	int hash = myHash(keyObject.hashCode(), table.length);
    	V valueObject=null;
    	if (table[hash]!=null) {
    		Node2 tempNode = table[hash];
    		while(tempNode!=null) {
    			if(tempNode.keyObject.equals(keyObject)) {
    				valueObject =(V) tempNode.valueObject;
    				break;
    				
    			}else {
					tempNode=tempNode.next;
				}
    			
    		}
			
		}
    
    	return valueObject;
    	
    	
    }
	public  void   put(K key,  V   value){
		//�������µĽڵ����
		Node2    newNode = new Node2();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.keyObject =  key;
		newNode.valueObject = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		
		Node2  iterLast = null;  //���ڱ��������һ��Ԫ��
		boolean  keyRepeat = false;  
		if(temp==null){
			//�˴�����Ԫ��Ϊ�գ���ֱ�ӽ��½ڵ�Ž�ȥ
			table[newNode.hash] = newNode;
		}else{
			//�˴�����Ԫ�ز�Ϊ�ա��������Ӧ������
			while(temp!=null){
				//�ж�key����ظ����򸲸�
				if(temp.keyObject.equals(key)){
					keyRepeat = true;
					temp.valueObject =  value;  //ֻ�Ǹ���value���ɡ�������ֵ(hash,key,next)���ֲ��䡣
					break;		
				}else{
					//key���ظ����������һ����
					iterLast = temp;
					temp = temp.next;					
				}
			}			
			if(!keyRepeat){   //û�з���key�ظ������������ӵ��������
				iterLast.next = newNode;
			}	
		}
	}

	public static void main(String[] args) {
		HashMap4 <Integer,String> m = new HashMap4<>();
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
		System.out.println(m.get(53));
	}
	
	
	public static  int  myHash(int  v, int length){
//		System.out.println("hash in myHash:"+(v&(length-1)));		//ֱ��λ���㣬Ч�ʸ�
//		System.out.println("hash in myHash:"+(v%(length-1)));		//ȡģ���㣬Ч�ʵ�
		return  v&(length-1);
	}
	
	
}

