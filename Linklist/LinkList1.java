
public class LinkList1 {
	
	private Node firstNode;
	private Node laNode;
	
	private int size;
	
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
		LinkList1 list1= new LinkList1();
		list1.add("a");
		list1.add("b");
		list1.add("a");
	
		
	}

}
