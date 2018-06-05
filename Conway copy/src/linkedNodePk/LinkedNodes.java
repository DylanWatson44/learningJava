package linkedNodePk;

import java.util.ArrayList;

public class LinkedNodes {

	private Node root;
	private ArrayList<Node> nodelist = new ArrayList<Node>();

	public LinkedNodes(double x, double y) {
		setRoot(new Node(x, y));
		getNodelist().add(root);
	}

	public void addNorth(Node currentNode, double x, double y) {
		if (currentNode.getNorthNode() != null) {
			addNorth(currentNode.getNorthNode(), x, y - 10);
		}
		Node nextNode = new Node(x, y - 10);
		currentNode.setNorthNode(nextNode);
		nextNode.setSouthNode(currentNode);
		getNodelist().add(nextNode);
	}

	public void addSouth(Node currentNode, double x, double y) {
		if (currentNode.getSouthNode() != null) {
			addSouth(currentNode.getSouthNode(), x, y + 10);
		}
		Node nextNode = new Node(x, y + 10);
		currentNode.setSouthNode(nextNode);
		nextNode.setNorthNode(currentNode);
		getNodelist().add(nextNode);
		
	}

	public void addWest(Node currentNode, double x, double y) {
		if (currentNode.getWestNode() != null) {
			addWest(currentNode.getWestNode(), x - 10, y);
		}
		Node nextNode = new Node(x - 10, y);
		currentNode.setWestNode(nextNode);
		nextNode.setEastNode(currentNode);
		getNodelist().add(nextNode);
	}

	public void addEast(Node currentNode, double x, double y) {
		if (currentNode.getEastNode() != null) {
			addEast(currentNode.getEastNode(), x + 10, y);
		}
		Node nextNode = new Node(x + 10, y);
		currentNode.setEastNode(nextNode);
		nextNode.setWestNode(currentNode);
		getNodelist().add(nextNode);
	}

	public Node findTopNode(Node currentNode) {
		if (currentNode.getNorthNode() != null) {
			currentNode = findTopNode(currentNode.getNorthNode());
		}
		return currentNode;
	}

	public Node findBottomNode(Node currentNode) {
		if (currentNode.getSouthNode() != null) {
			currentNode = findBottomNode(currentNode.getSouthNode());
		}
		return currentNode;
	}

	public Node findFarthestRight(Node currentNode) {
		if (currentNode.getEastNode() != null) {
			currentNode = findFarthestRight(currentNode.getEastNode());
		}
		return currentNode;
	}

	public Node findFarthestLeft(Node currentNode) {
		if (currentNode.getWestNode() != null) {
			currentNode = findFarthestLeft(currentNode.getWestNode());
		}
		return currentNode;
	}

	public Node findNW(Node currentNode) {
		if (currentNode.getWestNode() != null) {
			findNW(currentNode.getWestNode());
		}
		if (currentNode.getNorthNode() != null) {
			findNW(currentNode.getNorthNode());
		}
		return currentNode;
	}

	public Node findNE(Node currentNode) {
		if (currentNode.getEastNode() != null) {
			findNE(currentNode.getEastNode());
		}
		if (currentNode.getNorthNode() != null) {
			findNE(currentNode.getNorthNode());
		}
		return currentNode;
	}

	// public Node findSW(Node currentNode) {
	// if (currentNode.getSouthNode() != null) {
	// findBottom(currentNode.getSouthNode());
	// }
	// if (currentNode.getWestNode() != null) {
	// findSW(currentNode.getWestNode());
	// }
	// return currentNode;
	// }

	public Node findSE(Node currentNode) {
		if (currentNode.getSouthNode() != null) {
			findSE(currentNode.getSouthNode());
		}
		if (currentNode.getEastNode() != null) {
			findSE(currentNode.getEastNode());
		}

		return currentNode;
	}

	/**
	 * Will check all its neighbors and return true or false depending on the
	 * rules of the conway game
	 */
	public boolean shouldBeAlive(Node node) {
		int counter = 0;
		if (node.getNorthNode() != null) {
			if (node.getNorthNode().getStatus()) {
				counter++;
			}

			if (node.getNorthNode().getWestNode() != null) {
				if (node.getNorthNode().getWestNode().getStatus()) {
					counter++;
				}
			}
			if (node.getNorthNode().getEastNode() != null) {
				if (node.getNorthNode().getEastNode().getStatus()) {
					counter++;
				}
			}

		}
		if (node.getSouthNode() != null) {
			if (node.getSouthNode().getStatus()) {
				counter++;
			}

			if (node.getSouthNode().getWestNode() != null) {
				if (node.getSouthNode().getWestNode().getStatus()) {
					counter++;
				}
			}
			if (node.getSouthNode().getEastNode() != null) {
				if (node.getSouthNode().getEastNode().getStatus()) {
					counter++;
				}
			}
		}
		if (node.getWestNode() != null) {
			if (node.getWestNode().getStatus()) {
				counter++;
			}
		}
		if (node.getEastNode() != null) {
			if (node.getEastNode().getStatus()) {
				counter++;
			}
		}

		// if its alive
		if (node.getStatus()) {
			// if it has 2 0r 3 living neighbors
			if (counter == 2 || counter == 3) {
				return true;
			}

			// else if its dead
		} else {
			// if it has three living neighbors
			if (counter == 3) {
				return true;
			}
		}
		// else if all else fails
		return false;
	}

	/** uses recursion to check every cell using the shouldBeAlive method */
	public Node checkNextGen(Node currentNode) {
		if (!currentNode.getHasBeenChecked()) {
			currentNode.setNextGenStatus(shouldBeAlive(currentNode));
			currentNode.setHasBeenChecked(true);
		}
		if (currentNode.getNorthNode() != null) {
			if (!currentNode.getNorthNode().getHasBeenChecked()) {
				assert (currentNode.getNorthNode() != null);
				currentNode = currentNode.getNorthNode();
				checkNextGen(currentNode);
			}
		}
		if (currentNode.getWestNode() != null) {
			if(!currentNode.getWestNode().getHasBeenChecked()){
			currentNode = currentNode.getWestNode();
			checkNextGen(currentNode);
			}
		}
		if (currentNode.getSouthNode() != null) {
			if(!currentNode.getSouthNode().getHasBeenChecked()){
			currentNode = currentNode.getSouthNode();
			checkNextGen(currentNode);
			}
		}
		if (currentNode.getEastNode() != null) {
			if(!currentNode.getEastNode().getHasBeenChecked()){
			currentNode = currentNode.getEastNode();
			checkNextGen(currentNode);
			}
		}
		return currentNode;
	}

	/** call this with find SW */
	public void addBottomRow(Node currentNode) {
		if (currentNode.getSouthNode() == null) {
			addSouth(currentNode, currentNode.getX(), currentNode.getY());
			if (currentNode.getEastNode() != null) {
				addBottomRow(currentNode.getEastNode());
			}
		}
	}

	/** call this with find SE */
	public void joinBottomRow(Node currentNode) {
		if (currentNode.getNorthNode().getWestNode() != null) {
			currentNode.setWestNode(currentNode.getNorthNode().getWestNode().getSouthNode());
			currentNode.getNorthNode().getWestNode().getSouthNode().setEastNode(currentNode);
			joinBottomRow(currentNode.getWestNode());
		}
	}

	/** call this with find NW */
	public void addTopRow(Node currentNode) {
		if (currentNode.getNorthNode() == null) {
			addNorth(currentNode, currentNode.getX(), currentNode.getY());
			if (currentNode.getEastNode() != null) {
				addTopRow(currentNode.getEastNode());
			}
		}
	}

	/** call this with find NE */
	public void joinTopRow(Node currentNode) {
		if (currentNode.getSouthNode().getWestNode() != null) {
			currentNode.setWestNode(currentNode.getSouthNode().getWestNode().getNorthNode());
			currentNode.getSouthNode().getWestNode().getNorthNode().setEastNode(currentNode);
			joinTopRow(currentNode.getWestNode());
		}
	}

	/** call this with findNE */
	public void addRightRow(Node currentNode) {
		if (currentNode.getEastNode() == null) {
			addEast(currentNode, currentNode.getX(), currentNode.getY());
			if (currentNode.getSouthNode() != null) {
				addRightRow(currentNode.getSouthNode());
			}
		}
	}

	/** call this with find SE */
	public void joinRightRow(Node currentNode) {
		if (currentNode.getWestNode().getNorthNode() != null) {
			currentNode.setNorthNode(currentNode.getWestNode().getNorthNode().getEastNode());
			currentNode.getWestNode().getNorthNode().getEastNode().setSouthNode(currentNode);
			joinRightRow(currentNode.getNorthNode());
		}
	}

	/** call this with find NW */
	public void addLeftRow(Node currentNode) {
		if (currentNode.getWestNode() == null) {
			addWest(currentNode, currentNode.getX(), currentNode.getY());
			if (currentNode.getSouthNode() != null) {
				addLeftRow(currentNode.getSouthNode());
			}
		}
	}

	/** call this with find SW */
	public void joinLeftRow(Node currentNode) {
		if (currentNode.getEastNode().getNorthNode() != null) {
			currentNode.setNorthNode(currentNode.getEastNode().getNorthNode().getWestNode());
			currentNode.getEastNode().getNorthNode().getWestNode().setSouthNode(currentNode);
			joinLeftRow(currentNode.getNorthNode());
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public ArrayList<Node> getNodelist() {
		return nodelist;
	}

	public void setNodelist(ArrayList<Node> nodelist) {
		this.nodelist = nodelist;
	}

}
