import javax.management.RuntimeErrorException;
import javax.management.relation.InvalidRelationIdException;

public class LinkList2 {
	
	private Node firstNode;
	private Node laNode;
	
	private int size;
	
	public Object get(int index) {
		if (index<0 || index >size-1) {
			throw new RuntimeErrorException(null, "sb coder");	
		}
		Node teNode = firstNode;
		if (index <=(size>>1)) {
			for (int i = 0; i < index; i++) {	
			teNode=teNode.nexNode;
			}
		}else {
				for (int i = size-1;i>index; i--) {
					teNode=teNode.previousNode;
				}
				
			}
			
		return teNode.elementObject;
		
		
	}
	public void add(Object object) {
		Node node =  new Node(object);
		if(firstNode == null ) {
			node.previousNode=null;
			node.nexNode=null;
			firstNode = node;
			laNode=node;
		}else {
			node.previousNode=laNode;
			node.nexNode=null;
			
			laNode.nexNode=node;
			laNode=node;
		
		}
		size++;
		
	}
	public String toString() {	
		StringBuilder sBuilder = new StringBuilder("[");
		Node tempNode = firstNode;
		while (tempNode!=null) {
			tempNode=tempNode.nexNode;
			System.out.println(tempNode.elementObject);
			tempNode=tempNode.nexNode;
			
		}
		sBuilder.setCharAt(sBuilder.length()-1, ']');
		return "";
		}
	
	public static void  main(String[] args) {
		LinkList2 list1= new LinkList2();
		list1.add("a");
		list1.add("b");
		list1.add("a");
		System.out.println(list1.get(1));
	
		
	}

}
