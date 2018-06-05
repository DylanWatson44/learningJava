import java.awt.Color;

import ecs100.UI;

public class lolicolourclass {

	
	public void lolidrawing(double x, double y, double wd, double length){
		
		double middleX= x + wd/2;
		double middleY= y + wd/2;
		double stickbot = middleY + length;
		
		UI.setLineWidth(5);
		UI.setColor(Color.black);
		UI.drawLine(middleX, middleY, middleX, stickbot);
		
		UI.setColor(Color.red);
		UI.fillOval(x, y, wd, wd);
		
	
	}}

