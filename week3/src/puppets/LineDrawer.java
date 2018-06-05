package puppets;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class LineDrawer {
	private double startX, startY;
	private Color currentColor = Color.black;
	private void doChooseColour(){
		this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
		UI.setColor(this.currentColor);
	}
	public LineDrawer(){
		UI.setLineWidth(10);
		UI.setMouseListener(this::doMouse);
		UI.addButton("Color", this::doChooseColour);
	}
	public Color getCurrentColor(){
		return currentColor;}
	public void doMouse(String action, double x, double y){
		if(action.equals("pressed")){
			this.startX= x;
			this.startY=y;
		}
		else if (action.equals("released")){
			UI.drawLine(this.startX, this.startY, x, y);
		}
		else if (action.equals("clicked")){
			currentColor= getCurrentColor();
			UI.drawRect(x,  y,  100, 100);
		}

	}


	public static void main (String[] args){
		LineDrawer pm = new LineDrawer();

	}}
