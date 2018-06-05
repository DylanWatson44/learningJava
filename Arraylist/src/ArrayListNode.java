
public class ArrayListNode<E> {
	
	public ArrayListNode next;
	public E[] array;
	private int arraysize;
	
	public ArrayListNode(int size, E[] theArray){
		arraysize = size;
		 array = (E[]) new Object[arraysize];
	}
	
}
