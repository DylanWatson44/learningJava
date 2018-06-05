package arraysLists;

import ecs100.UI;

public class SeedTray {
private Flower[] seedtray = new Flower[8];

public SeedTray(){
	UI.addButton("Replant", this::doReplant);
	UI.addButton("Grow", this::doGrowAll);
	UI.addButton("Clear",  this::doClear);
}//seedtrayprogram
public void doReplant(){
	for(int i =0;i<seedtray.length;i++){
		this.seedtray[i] = new Flower(70+i*50, 400);
	}
}
public void doGrowAll(){
	for (int i =0; i<seedtray.length; i++){
		this.seedtray[i].grow(10*i+10);
	}
}
public void doClear(){
	UI.clearGraphics();
}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SeedTray thing = new SeedTray();

	}//voidmain
}//class
