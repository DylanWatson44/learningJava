
public class BinarySearchTree {
	private Node root;
	
	private void insert(Node newNode, Node currentNode){
		if(root==null){
			root=currentNode;
			System.out.println("Root node id: " + root.getID());
		}
		if(newNode.getID()<currentNode.getID()){
			if(currentNode.getLeftNode()==null){
				currentNode.setLeftNode(newNode);
			}
			else
				insert(newNode, currentNode.getLeftNode());
		}
	}
	public void insert(int id){
		Node newNode = new Node(id);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
