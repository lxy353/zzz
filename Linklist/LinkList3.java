import javax.management.RuntimeErrorException;

public class LinkList3 {
	
	private Node firstNode;
	private Node laNode;
	private int size;
	
	public void remove (int index) {
		Node teNode = getNode(index);
		if (teNode!=null) {
			Node upNode = teNode.previousNode;
			Node doNode = teNode.nexNode;
			upNode.nexNode=doNode;
			doNode.previousNode=upNode;
			if (index==0) {
				firstNode=doNode;	
			}
			if (index==size) {
				laNode=upNode;
			}
			size--;
		}
	}
	
	public Object get(int index) {
		if (index<0 || index >size-1) {
			throw new RuntimeErrorException(null, "sb coder");	
		}
		Node teNode = getNode(index);
		return teNode != null?teNode.elementObject:null;
		
	}
	
	public Node getNode(int index) {
		Node teNode = null;
		if (index <=(size>>1)) {
			teNode=firstNode;
			for (int i = 0; i < index; i++) {	
			teNode=teNode.nexNode;
			}
		}else {
			teNode=laNode;
				for (int i = size-1;i>index; i--) {
					teNode=teNode.previousNode;
				}
				
			}
		return teNode;			
		
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
		LinkList3 list1= new LinkList3();
		list1.add("a");
		list1.add("b");
		list1.add("a");
		System.out.println(list1.get(1));	
	}

}
