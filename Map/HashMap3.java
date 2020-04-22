import javax.xml.transform.Templates;

/**
 * �Զ���һ��HashMap
 *tostring
 * @author ���
 *
 */
public class HashMap3 {
	
	Node[]  table;    //λͰ���顣bucket  array
	int size;				//��ŵļ�ֵ�Եĸ���
	
	public HashMap3() {
		table = new Node[16];    //����һ�㶨���2��������
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
    public Object get(Object keyObject) {
    	int hash = myHash(keyObject.hashCode(), table.length);
    	Object valueObject=null;
    	if (table[hash]!=null) {
    		Node tempNode = table[hash];
    		while(tempNode!=null) {
    			if(tempNode.keyObject.equals(keyObject)) {
    				valueObject = tempNode.valueObject;
    				break;
    				
    			}else {
					tempNode=tempNode.next;
				}
    			
    		}
			
		}
    
    	return valueObject;
    	
    	
    }
	public  void   put(Object key,  Object   value){
		//�������µĽڵ����
		Node    newNode = new Node();
		newNode.hash = myHash(key.hashCode(),table.length);
		newNode.keyObject =  key;
		newNode.valueObject = value;
		newNode.next = null;
		
		Node temp = table[newNode.hash];
		
		Node  iterLast = null;  //���ڱ��������һ��Ԫ��
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
		HashMap3  m = new HashMap3();
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

