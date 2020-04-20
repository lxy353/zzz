
public class Node {
	Node previousNode;
	Node nexNode;
	Object elementObject;
	
	public Node(Node previousNode,Node nexNode,Object elementObject) {
		super();
		this.elementObject=elementObject;
		this.nexNode=nexNode;
		this.previousNode=previousNode;
	
	}

	public Node(Object elementObject) {
		super();
		this.elementObject = elementObject;
	}
	

}
