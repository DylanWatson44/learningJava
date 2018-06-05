import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {

	private int arraysize = 0;
	private E[] data = (E[]) new Object[arraysize];
	private int currentindex;		//field storing the last used index

	// public ArrayList(){
	// data = ;
	// }

	public boolean add(E arg0) {
		currentindex++;
		if (arraysize == 0)		//if the list is empty, start it at size 1
			arraysize++;
		
		if (currentindex == arraysize) {
			arrayDoubler();		//every time we hit the limit of the list we double the size
		}

		data[currentindex - 1] = arg0;

		return true;
	}

	public void add(int index, E value) {
		currentindex++;
		
		if (arraysize == 0)
			arraysize++;
		
		if (currentindex == arraysize) 
			arrayDoubler();
		

		for (int i = size() - 1; i > index; i--) {  //shuffles everything to the right
			E oldvalue = data[i - 1];				
			data[i] = oldvalue;
		}
		data[index] = value;						//then sets the specified index to the desired value

	}

	public boolean addAll(Collection<? extends E> arg0) {
		if (arg0.size() > 0) {
			for (E item : arg0) {
				add(item);
			}
			return true;
		}
		return false;
	}

	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		if (arg1.size() > 0) {
			int counter = arg0;
			for (E item : arg1) {
				add(counter, item);
				counter++;
			}
			return true;
		}
		return false;
	}

	public void clear() {
		arraysize = 0;
		currentindex = 0;
		data = (E[]) new Object[arraysize];
	}

	public boolean contains(Object arg0) {
		for (E item : data) {
			if (item == (arg0))
				return true;
		}

		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		if (arg0.size() > 0) {
			for (Object item : arg0) {
				if (!contains(item))
					return false;
			}

			return true;
		}
		return false;
	}

	public E get(int arg0) {
		return data[arg0];
	}

	public int indexOf(Object arg0) {
		for (int i = 0; i < size() - 1; i++) {
			if (data[i].equals(arg0))
				return i;
		}
		return -1;

	}

	public boolean isEmpty() {
		if (arraysize == 0) {
			return true;
		}
		return false;
	}

	public Iterator<E> iterator() {   //creates infinite loops

		Iterator<E> anIter = new Iterator<E>() {
			private int counter = 0;

			public boolean hasNext() {
				if (counter < size())
					return true;
				else
					return false;
			}

			public E next() {
				int currentindexA = counter;
				counter++;
				return data[currentindexA];
			}

		};
		return anIter;
	}

	public int lastIndexOf(Object arg0) {
		int lastindex = -1;
		for (int i = 0; i < size() - 1; i++) {
			if (data[i].equals(arg0)) {
				lastindex = i;
			}
		}
		return lastindex;

	}

	public ListIterator<E> listIterator() {

		return null;
	}

	public ListIterator<E> listIterator(int arg0) {

		return null;
	}

	public boolean remove(Object arg0) {
		int index = 0;
		for (E item : data) {
			index++;
			if (item.equals(arg0)) {
				remove(index);
				currentindex--;		//to make sure adding new stuff after calling this doesnt break anything
				return true;
			}
		}
		return false;
	}

	public E remove(int arg0) {
		E oldvalue = data[arg0];

		for (int i = arg0; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}
		currentindex--;
		return oldvalue;
	}

	public boolean removeAll(Collection<?> arg0) {
		if (arg0.size() > 0) {
			for (Object item : arg0) {
				remove(item);
			}
			return true;
		}
		return false;
	}

	public boolean retainAll(Collection<?> arg0) {

		return false;
	}

	public E set(int arg0, E arg1) {
		E oldvalue = data[arg0];
		data[arg0] = arg1;
		return oldvalue;
	}

	public int size() {
		return currentindex;
	}

	public List<E> subList(int arg0, int arg1) {  //gives nullpointers exceptions
		ArrayList<E> sublist = new ArrayList<E>();
		for (int i = arg0; i < arg1; i++) {
			sublist.add(data[i]);
		}
		return sublist;
	}

	public Object[] toArray() {
		Object[] newArray = new Object[size()];
		for (int i = 0; i < size(); i++) {
			newArray[i] = data[i];
		}
		return newArray;
	}

	public <T> T[] toArray(T[] arg0) {

		return null;
	}

	public void arrayDoubler() {		//new method to double list size
		arraysize = arraysize * 2;
		E[] newData = (E[]) new Object[arraysize];
		for (int i = 0; i < currentindex - 1; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}
