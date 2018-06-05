package arraysLists;
import ecs100.*; import java.util.*; import java.io.*;
public class Names {
	private ArrayList<String>allNames = new ArrayList<String>();
	public Names(){
		UI.initialise();
		UI.addButton("New", this::newList);
		UI.addTextField("Add",  this::addName);
		UI.addButton("List", this::displayList);
		UI.addTextField("Contains", this::doContains);
		UI.addTextField("Remove",this::doRemove);
		UI.addButton("Quit", UI::quit);
	}//Names
	public void addName(String name){
		if(this.allNames.contains(name)){
			UI.println(name +" is already on the list");
		}
		else{
			this.allNames.add(name);
			this.displayList();}
	}
	public void displayList(){
		UI.clearText();
		UI.printf("VIP List has %d names:%n", this.allNames.size());
		for(int i = 0; i< this.allNames.size(); i++){
			UI.printf("%3d: %s%n", i, this.allNames.get(i));
		}//for i
		UI.println("--------");
	}//displaylist
	public void doContains(String name){
		if(this.allNames.contains(name)){
			UI.println("Alright, " + name+ " is in the list, you can go on through");
		}//if
		else{
			UI.println("Sorry, bub, " +name + " is not in the list. No can do.");}
	}//doContains
	public void doRemove(String name){
		if(this.allNames.remove(name)){
		UI.println(name +" was removed");}//if
		else{
		UI.println(name +" was not present");}//else
		}//doremove
	public void newList(){
		this.allNames = new ArrayList<String>();
		//or could use allNames.clear()
		this.displayList();
	}
	public static void main(String[] args) {
		Names n = new Names();

	}//void main
}//class
