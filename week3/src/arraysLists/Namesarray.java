package arraysLists;

import ecs100.UI;

public class Namesarray {
	String[] firstnames=new String[]{"Sharon", "Pondy", "Monique", "Roma", "Benny"};
	int[]somenumber=new int[]{20, 45, 8};

	public Namesarray(){
		UI.initialise();
		UI.addButton("Clear", this::doClear);
		UI.addButton("Print Names", this::printNames);
		UI.addButton("print Numbers", this::printNumbers);
		UI.addButton("Reverse Names", this::doReverse);
	}
	public void doReverse(){
		for(int i=0;i<firstnames.length/2;i++){
			String temp = firstnames[i];
			firstnames[i] = firstnames[firstnames.length-i-1];
			firstnames[firstnames.length-i-1] = temp;
		}
	}
	public void printingNames(String[] names){
		for(String n : names){
			if(n != null){
				UI.println(n);
			}	
		}
		UI.printf("%n");
	}

	public void printNames(){
		printingNames(firstnames);
	}

	public void printNumbers(){
		for(int n : somenumber){
			UI.println(n);
		}
	}
	public void doClear(){
		UI.clearText();}


	public static void main(String[] args) {
		Namesarray n = new Namesarray();

	}

}
