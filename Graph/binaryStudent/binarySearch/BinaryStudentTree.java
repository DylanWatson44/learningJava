package binarySearch;

public class BinaryStudentTree {
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
	/**Method for inserting a new node using recursion. Depending on whos age is higher
	 * determines which path it goes down each time
	 */
	private void insert(Node newStudent, Node currentStudent) {
		if (root == null) //on the first iteration, our root field will be null, so we'll have to set the first node inputed as the root
			root = newStudent;
		else {
			if (currentStudent.getStudent().getAge() < newStudent.getStudent().getAge()) {	//if the age of next student added is greater than the current one 
				if (currentStudent.getRightNode() != null)									//then try again from the top using recursion, going down the right branch
					insert(newStudent, currentStudent.getRightNode());
				else {
					currentStudent.setRightNode(newStudent);	
				}
			}
			else {
				if (currentStudent.getLeftNode() != null)									//else try find a node  with an empty child going down the left branch
					insert(newStudent, currentStudent.getLeftNode());
				else {
					currentStudent.setLeftNode(newStudent);
				}
			}
		}
	}
/**Method for creating a new node and then calls the recursive insert method*/
	public void insert(int age, String name, int id) {
		Node newStudent = new Node(age, name, id);
		insert(newStudent, root);
	}
/**Method for finding the oldest student. Logically, this is just the person at the bottom of the farthest right branch*/
	public String findOldest(Node currentStudent) {
		while (currentStudent.getRightNode() != null) {
			currentStudent = currentStudent.getRightNode();
			findOldest(currentStudent);
		}

		return ("The oldest student is: " + currentStudent.getStudent().getName() + ", Age "
				+ currentStudent.getStudent().getAge());
	}

}
