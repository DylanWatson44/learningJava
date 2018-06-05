package binarySearch;

public class Client {
	
	public static void main(String[] args) {
		BinaryStudentTree myTree = new BinaryStudentTree();
		myTree.insert(18, "Jack", 1);
		myTree.insert(17, "Susan", 2);
		myTree.insert(33, "Butch", 3);
		myTree.insert(42, "George", 4);
		myTree.insert(16, "Carrie", 5);
		String oldestStudent = myTree.findOldest(myTree.getRoot());
		System.out.println(oldestStudent);
	}
}
