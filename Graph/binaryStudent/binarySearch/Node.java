package binarySearch;

public class Node {
	private int id;
	private Student student;
	private Node leftNode, rightNode;

	public Node(int studentAge, String studentName, int ID) {
		setStudent(new Student(studentName, studentAge));
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
