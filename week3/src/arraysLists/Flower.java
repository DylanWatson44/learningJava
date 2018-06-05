package arraysLists;

import java.awt.Color;

import ecs100.UI;

public class Flower {
	//fields
	private double baseX, baseY, height;
	private boolean blooming;
	private String stage;
	
	public Flower(double x, double y){  
		this.baseX = x;
		this.baseY = y;
		this.blooming = false;
		this.height = 20;
		this.draw();
		
	}//constructor
	public void grow(int amt){
		this.erase();
		this.height = this.height + amt;
		this.draw(); }
	public void erase() {
		UI.eraseRect(this.baseX-2, (this.baseY-this.height), 5, this.height);
		double radius = 10;
		if (this.blooming){
			radius = 20;
		}
		UI.eraseOval(this.baseX-radius, this.baseY-this.height-radius, 2*radius, 2*radius);
	}
	public void bloom(){
		this.erase();
		this.blooming = true;
		this.draw(); }
	public void draw(){
		UI.setColor(Color.green);
		UI.fillRect(this.baseX-2, this.baseY-this.height, 5,this.height);
		if(this.blooming){
			UI.setColor(Color.red);
			UI.fillOval(this.baseX-20, this.baseY-this.height-20, 40,40);}
		else{
			UI.setColor(Color.green);
			UI.fillOval(this.baseX-10,  this.baseY-this.height-10,  20,  20);}
		UI.sleep(1000);
		}}
	


