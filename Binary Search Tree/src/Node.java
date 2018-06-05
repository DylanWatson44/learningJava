
public class Node {
	private int id;
	private Node leftNode, rightNode;

	public Node(int ID) {
		id = ID;
	}
public int getID(){
	return id;
}
	public Node getLeftNode() {
		return leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setLeftNode(Node n) {
		leftNode = n;
	}

	public void setRightNode(Node n) {
		rightNode = n;
	}
}
