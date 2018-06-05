package numbersPackage;

import java.io.PrintStream;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import ecs100.*;

public class Numbers {
	private PrintStream outputFile;
	private double barX = 0;
	private static final double BASE = 450;

	public Numbers(){
		UI.setMouseListener(this::doMouse);
		UI.addButton("New", this::doNew);
		UI.drawLine(0, BASE, 600, BASE);
	}//public numbers
	public void doNew(){
		UI.clearPanes();
		UI.drawLine(0, BASE, 600, BASE);
		this.barX = 0;
		if(this.outputFile != null){
			this.outputFile.close();}
		try{
			this.outputFile = new PrintStream(new File(UIFileChooser.save()));
		} catch(IOException e) {UI.println("File error" + e);}
	}//doNew
	public void doMouse(String action, double x, double y){
		if(action.equals("pressed")){
			double number = BASE - y;
			this.barX = this.barX + 12;
			UI.setColor(Color.blue);
			UI.fillRect(this.barX, y, 10, number);
			UI.println(number);
			if (this.outputFile != null){
				this.outputFile.println(number);
			}
		}


	}//doMouse
	public static void main(String[] args){ 
		new Numbers();}
}//class
