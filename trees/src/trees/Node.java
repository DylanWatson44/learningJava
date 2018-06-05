package trees;

class Node {

	// Attributes.
	private int id;
	private Node leftChild, rightChild;

	// Getters.
	int getID() {
		return id;
	}

	Node getLeftChild() {
		return leftChild;
	}

	Node getRightChild() {
		return rightChild;
	}

	// Setters.
	void setID(int cID) {
		id = cID;
	}

	void setLeftChild(Node cLeftChild) {
		leftChild = cLeftChild;
	}

	void setRightChild(Node cRightChild) {
		rightChild = cRightChild;
	}
}
