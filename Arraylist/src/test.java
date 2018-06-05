import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		ArrayList<String> myArray = new ArrayList<String>();

		myArray.add("A");
		myArray.add("B");
		myArray.add("C");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}
		Set<String> anotherArray = new HashSet<String>();
		anotherArray.add("Z");
		anotherArray.add("X");

		Set<String> zeArray = new HashSet<String>();
		zeArray.add("Z");
		zeArray.add("X");

		myArray.addAll(1, zeArray);

		System.out.println();
		
//			do System.out.println(myArray.iterator().next());
//			while (myArray.iterator().hasNext());
		// for(int i=0;i<myArray.size();i++){
		// System.out.println(myArray.get(i));
		// }
		// System.out.println(myArray.size());
		// Object[] someArray = myArray.toArray();
		// for(Object item : someArray){
		// System.out.println(item);
		// }
		// System.out.println();
		// List<String> ourSub= myArray.subList(0, 3);
		// for(String item : ourSub)
		// System.out.println(item);
	}

}
