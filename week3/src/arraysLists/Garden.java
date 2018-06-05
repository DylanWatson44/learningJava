package arraysLists;

import java.util.ArrayList;

import ecs100.*;

public class Garden {
	private ArrayList<Flower> flowers = new ArrayList<Flower>();
	private int selectedFlower;
	public Garden(){  //CONSTRUCTOR
		UI.setMouseListener(this::doMouse);
		UI.addButton("Clear", this::doClear);
		UI.addButton("Grow", this::doGrow);
		UI.addButton("Bloom", this::doBloom);
		// UI.addButton("Pick", this::doPick);
	}//garden

	public void doGrow(){
		for(int i =0;i<this.flowers.size(); i++){
			this.flowers.get(i).grow(10);
		}//for
	}//dogrow
	public void doMouse(String action, double x, double y){
		if (action.equals("pressed")){
			Flower fl = new Flower(x,y);
			this.flowers.add(fl);}//if
		}//domouse
		public void doBloom(){
			for(int i =0;i<this.flowers.size();i++){
				this.flowers.get(i).bloom();}
		}//dobloom
		public void doClear(){
			this.flowers.clear();
			UI.clearGraphics();
		}//doclear
		public static void main(String[] args){
			Garden n = new Garden();
		}

	
}//class
