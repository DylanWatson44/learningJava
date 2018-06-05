package trees;

import java.util.ArrayList;

public class BST {

	// Attributes.
	private Node root;

	// Getters.
	public Node getRoot() {
		return root;
	}

	// Setters.
	public void setRoot(Node cRoot) {
		root = cRoot;
	}

	// Methods.
	private Node createNode(int cID) {

		Node node = new Node();

		node.setID(cID);

		return node;
	}

	private void insert(Node newNode, Node currentRoot) {

		if (root == null) {

			System.out.println("\nRoot: " + newNode.getID());

			root = newNode;
		}

		else {

			if (currentRoot.getID() < newNode.getID()) {

				if (currentRoot.getRightChild() != null)
					insert(newNode, currentRoot.getRightChild());

				else {

					System.out.println("\nRight child: " + newNode.getID() + " of " + currentRoot.getID());

					currentRoot.setRightChild(newNode);
				}
			}

			else {

				if (currentRoot.getLeftChild() != null)
					insert(newNode, currentRoot.getLeftChild());

				else {

					System.out.println("\nLeft child: " + newNode.getID() + " of " + currentRoot.getID());

					currentRoot.setLeftChild(newNode);
				}
			}
		}
	}

	public void print(Node currentNode) {

		if (currentNode != null && currentNode.getLeftChild() != null)
			print(currentNode.getLeftChild());

		if (currentNode != null && currentNode.getRightChild() != null)
			print(currentNode.getRightChild());

		if (currentNode != null)
			System.out.println(currentNode.getID());

	}

	public void insert(int id) {

		Node node = createNode(id);

		insert(node, root);
	}

	// printing the key of a node between printing the values of its left and
	// right subtree.

	public void inOrder(Node currentNode) {
		if (currentNode.getLeftChild() != null) {
			inOrder(currentNode.getLeftChild());
		}
		System.out.println(currentNode.getID());
		if (currentNode.getRightChild() != null) {
			inOrder(currentNode.getRightChild());
		}
	}

	// printing the key of a node before printing the values of its both
	// subtrees
	public void preOrder(Node currentNode) {

		System.out.println(currentNode.getID());
		if (currentNode.getLeftChild() != null) {
			preOrder(currentNode.getLeftChild());
		}

		if (currentNode.getRightChild() != null) {
			preOrder(currentNode.getRightChild());
		}
	}

	// printing the key of a node after printing the values of its both
	// subtrees.
	public void postOrder(Node currentNode) {

		if (currentNode.getLeftChild() != null) {
			postOrder(currentNode.getLeftChild());
		}

		if (currentNode.getRightChild() != null) {
			postOrder(currentNode.getRightChild());
		}
		System.out.println(currentNode.getID());
	}

	public static void main(String[] args) {

		BST tree = new BST();
		tree.insert(8);
		tree.insert(5);
		tree.insert(9);
		tree.insert(2);
		tree.insert(6);

		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}
