package puppets;
import ecs100.*;

public class PuppetMaster {
private CartoonFigure cf1 = new CartoonFigure(200, 100, "blue");
private CartoonFigure cf2 = new CartoonFigure(400, 100, "green");
private CartoonFigure selectedFigure = cf1;
private double walkDist = 20;
	public PuppetMaster(){
		UI.addButton("Tim", this::doTim);
		UI.addButton("Fin", this::doFin);
		UI.addButton("Smile", this::doSmile);
		UI.addButton("Frown", this::doFrown);
		UI.addButton("Left", this::doLeft);
		UI.addButton("Right", this:: doRight);
		UI.addTextField("Say", this::doSpeak);
		UI.addButton("Walk", this::doWalk);
		UI.addSlider("Distance", 1,100,20, this::setDist);
	}
	public void doTim(){
		this.selectedFigure= cf1;
	}
	public void doFin(){
		this.selectedFigure=cf2;
	}
	public void doSmile(){
		this.selectedFigure.smile();
	}
	public void doFrown(){
		this.selectedFigure.frown();
	}
	public void doSpeak(String words){
		this.selectedFigure.speak(words);
	}
	public void doLeft(){
		this.selectedFigure.lookLeft();
	}
	public void doRight(){
		this.selectedFigure.lookRight();
	}
	public void doWalk(){
		this.selectedFigure.walk(this.walkDist);
	}
	public void setDist(double value){
		this.walkDist = value;
	}
	
	
	public static void main(String[] args){
		PuppetMaster pm = new PuppetMaster();
	}
}
