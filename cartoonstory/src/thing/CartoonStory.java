package thing;

import java.util.ArrayList;

import ecs100.UI;

public class CartoonStory {
	public CartoonStory(){
		UI.addButton("go", this::playStory);
	}
	CartoonCharacter Jan = new CartoonCharacter(300, 100, "blue");
	CartoonCharacter Jim= new CartoonCharacter(150, 100, "green");
	public void playStory(){
		
	
		ArrayList <CartoonCharacter> hub = new ArrayList<CartoonCharacter>();
		Jim.lookLeft();
		Jim.speak("help");
		for (int i =0;i<=50;i++){
			hub.add(new CartoonCharacter(Math.random()*500,Math.random()*100, "blue"));
			
		for (CartoonCharacter n :hub){
			(n).draw();}
//		for (CartoonCharacter n :hub){
//			(n).walk(50);
//			(n).lookLeft();
//			(n).lookRight();
//		}
		}
		
		
	}//playstory

	public static void main(String[] args) {
		CartoonStory cs = new CartoonStory();

	}//main

}//class
