
public class test {

	public static void main(String[] args) {
		LinkedList<String> mylinkedlist = new LinkedList<String>();
		mylinkedlist.add("A");
		mylinkedlist.add("B");
		mylinkedlist.add("C");

		System.out.println("size of list: " + mylinkedlist.size());
		System.out.println("0th index: " +mylinkedlist.get(0));
		System.out.println("1st index: " + mylinkedlist.get(1));
		System.out.println("2nd index: " + mylinkedlist.get(2));
		int i =2;
		mylinkedlist.remove(i);
		System.out.println("removed the item at index " + i);
		System.out.println("0th index: " +mylinkedlist.get(0));
		System.out.println("size of list: " + mylinkedlist.size());
		System.out.println("1st index: " + mylinkedlist.get(1));

	}

}
