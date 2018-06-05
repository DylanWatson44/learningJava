import java.util.ArrayList;

public class YourCode {
	// Return an ArrayList that contains twice each of the numbers
	// in the input list.
	//
	// For example, if input contained [1,2,10] this method should
	// return a list with [2,4,20].
	//
	// You should not modify the input ArrayList.
	public ArrayList<Double> mapTwice(ArrayList<Double> input) {

		ArrayList<Double> mylist= new ArrayList<Double>(); // declare and initialize new array
		for( double i : input){   
			double a = i*2;			
			mylist.add(a);		//add doubled versions of each index

		}
		return mylist;


	}

	// Return an ArrayList that contains the strings from the
	// input list, in the same order, converted to upper case.
	//
	// Hint: The toUpperCase() method on String returns an
	// uppercased version of the string.
	//
	// You should not modify the input ArrayList.
	public ArrayList<String> mapToUpper(ArrayList<String> input) {
		ArrayList<String> mystringlist = new ArrayList<String>();
		for (String i : input){
			String b = i.toUpperCase();	
			mystringlist.add(b);

		}


		return mystringlist;
	}

	// Return true if word is a palindrome, reading the same
	// backwards and forwards.
	//
	// Hint: the substring(int beginIndex, int endIndex)
	// method gives the part of the string from beginIndex
	// (inclusive) to endIndex (exclusive).
	// Hint: charAt(int index) gives the character at the
	// given position in a string as a char, which is a
	// primitive type that can be used as an integer.
	// Hint: Strings have a length() method.
	public boolean isPalindrome(String word) {

		ArrayList<Integer> arraylist1 = new ArrayList<Integer>();

		for (int i =0; i <word.length(); i++){			//creating an array of characters from the input word
			arraylist1.add((int) word.charAt(i));}

		ArrayList<Integer> arraylist2 = new ArrayList<Integer>(); //creating another array which is copy of the first so that we can reverse it in the next step
		arraylist2.addAll(arraylist1);

		for(int i =0;i<=(arraylist2.size()-1)/2;i++){
			Integer temp= arraylist2.get(i);
			arraylist2.set(i, (arraylist2.get(arraylist2.size()-i-1)));
			arraylist2.set((arraylist2.size()-i-1), temp);}

		for(int b =0; b<=(arraylist1.size()-1); b++){		//compares the indexes of the two arrays, returns false if any index is not the same (and therefore not a palindrome)
			if((arraylist1.get(b))!=(arraylist2.get(b))){
				return false;
			}
		}

		return true;
	}

	// Return an ArrayList that contains the strings from the
	// input list starting with the given prefix, in the same
	// order they appeared.
	//
	// Hint: the startsWith(String prefix) method on String returns
	// true if and only if the string starts with the prefix.
	//
	// You should not modify the input ArrayList.
	public ArrayList<String> filterStarts(ArrayList<String> input, String prefix) {
		ArrayList<String> killerarray = new ArrayList<String>();
		for (String n : input){
			if (n.startsWith(prefix)){
				killerarray.add(n);   //checks if the value at the given index has the desired prefix, if it does it adds to the return array
			}
		}


		return killerarray;
	}

	// Return the sum of all numbers in the input list.
	//
	// For example, if input contained [1,2,10] this method should
	// return 13.
	//
	// You should not modify the input ArrayList.
	
	public double foldSum(ArrayList<Double> input) {
		double x = 0;
		for(Double n : input){
			x= x + n; //for every value at index(n), add it to variable x along with itself to find the total
		}
		return x;
	}

	// Return whether the list is ordered from lowest to highest.
	//
	// For example, if input contained [1,2,3] this method should
	// return true, while if input contained [1,3,2] it should
	// return false.
	//
	// You should not modify the input ArrayList.
	public boolean isOrderedAscending(ArrayList<Double> input) {

		for(Double n = 0.0; n < input.size()-1; n++){				
			if (n > input.get((int) (n+1))){
				return false;} //goes through every index, checking if the index after it is greater than itself and returning false if it is. otherwise nothing happens and it goes to return true
		}
		return true;


	}

	// Return an ArrayList that contains the words from
	// list input1 that are in the same position in
	// input2.
	//
	// Remember: compare Strings with .equals(other)
	//
	// You should not modify the input ArrayLists.
	public ArrayList<String> matchingWords(
			ArrayList<String> input1,
			ArrayList<String> input2) {
		
		ArrayList<String> funNewArray = new ArrayList<String>();
		for(int n = 0; n <= (input1.size()-1) && n <= (input2.size()-1); n++){  //made sure that int n could not go out of bounds for either list
			if (input1.get(n).equals(input2.get(n))){  //if the value at index n is the same for both lists, add it to a new list
				funNewArray.add(input1.get(n));
			}
		}

		return funNewArray;
	}

	// Return an ArrayList that contains all the words in
	// the input1 list that are also in the input2 list.
	//
	// Hint: You will use nested loops.
	// Hint: You will probably need a boolean variable.
	//
	// You should not modify the input ArrayLists.
	public ArrayList<String> intersection(
			ArrayList<String> input1,
			ArrayList<String> input2) {
		ArrayList<String> thebestarray= new ArrayList<String>();
		for(int n = 0; n <= (input1.size()-1); n++){
			for(int b = 0; b <= (input2.size()-1); b++){
				if(input1.get(n).equals(input2.get(b))){  //iterates over every possible pair of indexes, only adding a value to the new list if it finds a match
					thebestarray.add(input1.get(n));
				}
			}
		}
		return thebestarray;
	}

	// Return an ArrayList that contains all the words in
	// the input1 list with any duplicate occurrences
	// removed. Keep the first time any duplicate word
	// appears.
	//
	// Hint: You will use nested loops.
	// Hint: Remember that everything is equal to itself.
	//
	// You should not modify the input ArrayList.
	public ArrayList<String> noDuplicates(
			ArrayList<String> input) {
		
		ArrayList<String> fancyarray = new ArrayList<String>();
		for(int i = 0; i<=input.size()-1; i++){
			for(int b=0;b<fancyarray.size()+1 && b<input.size()-1;b++){
				if(fancyarray.contains(input.get(i))){}  //if my array already contains the value, do nothing, but if it doesnt, add it to the list (probably could have done it with (if not)
				else{
					fancyarray.add(input.get(i));
				}
			}
		}
		return fancyarray;
	}

	// Return an ArrayList that contains all the words in
	// the input1 list that are NOT in the input2 list.
	// Duplicated words in input1 that are not in input2
	// will appear more than once.
	//
	// You should not modify the input ArrayLists.
	public ArrayList<String> difference(
			ArrayList<String> input1,
			ArrayList<String> input2) {

		ArrayList<String> anotherlist = new ArrayList<String>();

		for(int i =0;i<=input1.size()-1;i++){
			if (!input2.contains(input1.get(i))){
				anotherlist.add(input1.get(i)); //if input2 does not contain whats at input1(i), then add that value to the list
			}
		}
		return anotherlist;
	}

	// Return an ArrayList that contains all the words that
	// are in exactly one of the input lists. Duplicated words
	// in each list should appear appropriately.
	//
	// You should not modify the input ArrayLists.
	public ArrayList<String> symmetricDifference(
			ArrayList<String> input1,
			ArrayList<String> input2) {
		 	
		ArrayList <String> humblearray= new ArrayList<String>();

		for(int i=0;i<=input1.size()-1;i++){     // for every index in input one, if input2 does not have that value, then add it to the new list
			if(!input2.contains(input1.get(i))){
				humblearray.add(input1.get(i));}
		}
		for (int b=0;b<=input2.size()-1; b++){	 // similarly, we have to go through the second list and do the same (probably could have done it in one for loop, but just in case I made another)
			if(!input1.contains(input2.get(b))){
				humblearray.add(input2.get(b));}
		}
		return humblearray;
	}

	// Reverse the input list, in place.
	//
	// Hint: The set(index, value) method on ArrayLists updates
	// the value stored at a given index.
	public void reverse(ArrayList<String> input) {

		for(int i =0;i<=(input.size()-1)/2;i++){  //iterates over HALF the indexes(so that the positions aren't swapped twice), swapping each index with the one at the reverse end.
			String temp= input.get(i);   
			input.set(i, (input.get(input.size()-i-1)));
			input.set((input.size()-i-1), temp);}
	}

	// Shuffle the input list, in place, by swapping the element
	// at each position with one at a randomly-chosen equal or
	// later index
	//
	// Hint: You can generate a random integer from 0 to n - 1 with
	// (int)(Math.random() * n), and one from x to n - 1 with
	// x + (int)(Math.random() * (n - x)).
	public void shuffle(ArrayList<Double> input) { 

		for(int i = 0;i<input.size()-1;i++){
			double temp= input.get(i); 
			double x = i+1; 										//we want the range of possible random indexes to be only ones larger than the initial index

			int c = (int) (x + (Math.random()*(input.size()-x))); 	//generating that random index

			input.set(i, (double)c);								//swapping the two indexes
			input.set(c, temp);


		}
	}

	// Return true if word1 and word2 are anagrams of one
	// another. One word is an anagram of another if it
	// has all the letters of the other word in a different
	// order.
	//
	// Hint: the substring(int beginIndex, int endIndex)
	// method gives the part of the string from beginIndex
	// (inclusive) to endIndex (exclusive).
	// Hint: charAt(int index) gives the character at the
	// given position in a string as a char, which is a
	// primitive type that can be used as an integer.
	public boolean isAnagram(String word1, String word2) {
		ArrayList<Integer> arraylist1= new ArrayList<Integer>();
		ArrayList<Integer> arraylist2= new ArrayList<Integer>();

		for(int i = 0; i<(word1.length());i++){
			arraylist1.add((int) word1.charAt(i));}

		for(int i = 0; i<(word2.length());i++){
			arraylist2.add((int) word2.charAt(i));} //at this point we have two arraylists with integers for each input word

		if(arraylist1.size()!=arraylist2.size()){ //check to see if the words are the same length, they cannot be anagrams otherwise
			return false;
		}

		for(int d = 0;d < (arraylist1.size()*arraylist1.size()); d++){ //This block and the one after it are using the sort code from Q16 to sorting the two lists into alphabetical order. This might seem odd, however, this means when we check each index form each list it wont return true if the tested words are 'wdwdw' and 'dwdwd' for example.
			for(int i =0;i<arraylist1.size()-1;i++){
				Integer oneup= arraylist1.get(i +1);
				if(arraylist1.get(i)>oneup){
					Integer temp= arraylist1.get(i);
					arraylist1.set(i, (oneup));
					arraylist1.set((i+1), temp);
				}}}

		for(int d = 0;d < (arraylist2.size()*arraylist2.size()); d++){
			for(int i =0;i<arraylist2.size()-1;i++){
				Integer oneup= arraylist2.get(i +1);
				if(arraylist2.get(i)>oneup){
					Integer temp= arraylist2.get(i);
					arraylist2.set(i, (oneup));
					arraylist2.set((i+1), temp);
				}}}

		for(int x =0;x<arraylist1.size()-1;x++)  //testing the indexes of each array against eachother
			if(arraylist1.get(x)!=arraylist2.get(x)){
				return false;
			}

		return true;

	}

	// Return an ArrayList with a rolling five-item Olympic average
	// of the numbers in the input list.
	//
	// An Olympic average of five numbers is the average of the three
	// numbers left after ignoring the lowest and highest numbers. For
	// example, the Olympic average of [9,7,5,6,8] is the average of
	// 7, 6, and 8 (which is 7: (7 + 6 + 8) / 3 = 21 / 3).
	//
	// A rolling average over a list of numbers is a list of the averages
	// of consecutive numbers in the first list centred around each
	// possible point in the first list.
	//
	// Your method should return an Olympic average of each five-item
	// sequence of consecutive numbers in the list.
	//
	// You should not modify the input ArrayList.
	public ArrayList<Double> olympicAverages(ArrayList<Double> input) {
		ArrayList<Double> rollingaverages= new ArrayList<Double>(); //arraylist where we store the rolling averages


		for(int i =2;i<=input.size()-3;i++){  //start at 2 (so that we dont have negative indexes) and end 2 positions before the end(for similar reasons)
			ArrayList<Double> x= new ArrayList<Double>(); //temporary arraylist where 5 positions from input will be stored  

			for(int b =i-2; b<=i+2;b++){ // stores the 5 indexes around index i 
				x.add(input.get(i));}


			Double smallest = Double.MAX_VALUE; //working out the min and max values, to do that we have to initialize min and max to the largest and smallest values respectively
			Double largest = Double.MIN_VALUE;

			for (int n = 0; n<=4;n++){
				if(x.get(n)< smallest){
					smallest = x.get(n);}
				if(x.get(n)> largest){		
					largest = x.get(n);}}


			Double average= 0.0;
			for (int s = 0; s<=4;s++){
				average= average +x.get(s);}

			average = (average-largest-smallest)/3; 	 //this was my method of working out the average and removing the min and max values
			rollingaverages.add(average);
			x.clear();} 		// this is import for making sure that each iteration has a fresh list to work with

		return rollingaverages;
	}

	// Order all the numbers in the input list from lowest to highest.
	//
	// Hint: You can loop over the list repeatedly until it is in order,
	// swapping adjacent items that are out of order.
	public void orderAscending(ArrayList<Double> input) {
		for(int d = 0;d < (input.size()*input.size()); d++){ //slightly cheated here, I could have recycled the code from question 6 and used an if statement to check if was true or if it needed to loop again, but since n*n is always going to cover the worst case scenario I thought it was fine.
			for(int i =0;i<input.size()-1;i++){

				Double oneup= input.get(i +1); //variable that allows us to work adjacent pairs

				if(input.get(i)>oneup){  //this block switches pairs if the first number is larger than the second.
					Double temp= input.get(i);
					input.set(i, (oneup));
					input.set((i+1), temp);
				}
			}
		}
	}
	// The previous method takes up to n^2 steps for a list with size n.
	// It could be faster. This method should do the same thing, but
	// taking many fewer steps.
	public void orderAscendingFaster(ArrayList<Double> input) {
		for(int i = 0;i <= (input.size()-1); i++){
			for(int d =i+1; d<=input.size()-1; d++){

				Double nextup= input.get(d);

				if(input.get(i)>nextup){	//this time round, instead of iterating over each pair again and again, we only have to consider each pair of indexes once. 
					Double temp= input.get(i);
					input.set(i, (nextup));
					input.set(d, temp);
				}
			}
		}
	}

	// Reverse a string correctly.
	public String reverseString(String input) {
		ArrayList<Character> arraylist1 = new ArrayList<Character>();
		for (int i =0; i <input.length(); i++){		//convert string to char
			arraylist1.add(input.charAt(i));}

		for(int i =0;i<=(arraylist1.size()-1)/2;i++){  //swap char around
			char temp= arraylist1.get(i);
			arraylist1.set(i, (arraylist1.get(arraylist1.size()-i-1)));
			arraylist1.set((arraylist1.size()-i-1), temp);}

		String newreverse= "";

		for(int i =0;i<=arraylist1.size()-1;i++){ //concatenate reversed characters into a string 
			newreverse= newreverse + (arraylist1.get(i));}		
		return newreverse;
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}
