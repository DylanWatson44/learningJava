import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {

	private LinkedNode<E> head;

	public boolean add(E v) {
		if (head == null) {
			head = new LinkedNode<E>(v);

		} else {
			LinkedNode<E> h = head;
			while (h.next != null) {
				h = h.next;
			}
			h.next = new LinkedNode<E>(v);

		}

		return true;
	}

	public void add(int indx, E Value) {
		int listcounter = 0;
		LinkedNode<E> newobject = new LinkedNode<E>(Value);

		LinkedNode<E> h = head;

		if (indx == 0) {
			head.next = head;
			head = newobject;
		} else {

			while (listcounter != indx - 1) {
				listcounter++;
				h = h.next;
			}
			LinkedNode<E> oldobjectminus1 = h;
			LinkedNode<E> oldobject = h.next;
			newobject.next = oldobject;
			oldobjectminus1.next = newobject;
		}
	}

	public boolean addAll(Collection<? extends E> arg0) {

		return false;
	}

	public boolean addAll(int arg0, Collection<? extends E> arg1) {

		return false;
	}

	public void clear() {
		head = null;
	}

	public boolean contains(Object arg0) {

		return false;
	}

	public boolean containsAll(Collection<?> arg0) {

		return false;
	}

	public E get(int arg0) {
		int listcount = 0;
		LinkedNode<E> h = head;
		E value = head.value;
		while (listcount != arg0) {
			listcount++;
			h = h.next;
			value = h.value;
		}

		return value;
	}

	public int indexOf(Object arg0) {

		return 0;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public Iterator<E> iterator() {

		return null;
	}

	public int lastIndexOf(Object arg0) {

		return 0;
	}

	public ListIterator<E> listIterator() {

		return null;
	}

	public ListIterator<E> listIterator(int arg0) {

		return null;
	}

	public boolean remove(Object arg0) {

		return false;
	}

	public E remove(int indx) {
		int listcounter = 0;
		LinkedNode<E> h = head;

		if (indx == 0) {
			head = head.next;
		} else {
			while (listcounter != (indx - 1)) {
				h = h.next;
				listcounter++;
			}
			LinkedNode<E> nodebefore = h;
			LinkedNode<E> nodetoberemoved = h.next;
			nodebefore.next = nodetoberemoved.next;
			return nodebefore.value;
		}
		return head.value;
	}

	public boolean removeAll(Collection<?> arg0) {

		return false;
	}

	public boolean retainAll(Collection<?> arg0) {

		return false;
	}

	public E set(int arg0, E arg1) {
		int listcount = 0;
		LinkedNode<E> h = head;
		if (arg0 == 0) {
			head.value = arg1;
		} else {

			while (listcount != arg0) {
				listcount++;
				h = h.next;
			}
			h.value = arg1;

		}
		return h.value;
	}

	public int size() {
		int listcount = 0;
		if (head == null) {
			return listcount;
		}

		else {
			LinkedNode<E> h = head;
			listcount++;
			while (h.next != null) {
				h = h.next;
				listcount++;
			}
			return listcount;
		}

	}

	public List<E> subList(int arg0, int arg1) {

		return null;
	}

	public Object[] toArray() {

		return null;
	}

	public <T> T[] toArray(T[] arg0) {

		return null;
	}

}
