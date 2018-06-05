import ecs100.UI;
import java.awt.Color;
public class Lolipop {

/** This is class with a single method for  drawing a simple lolipop. It takes multiple 
 * double variable parameters and uses those to determine the start point and size of 
 * the lolipops. Additionally there is a boolean to set whether or not random colours 
 * for the oval of the lolipop should be used(only important for the third test).
 * 
 * @param x starting x position
 * @param y starting y position
 * @param wd size of oval
 * @param length size of stick
 * @param randomcolour boolean for random colours.
 */
	
public void lolidrawing(double x, double y, double wd, double length, boolean randomcolour){
	
	double middleX= x + wd/2;   //middelX and middleY created because it is
	double middleY= y + wd/2;	//easier to draw things relative to the center of oval
	double stickbot = middleY + length;
	
	UI.setLineWidth(5);
	UI.setColor(Color.black);
	UI.drawLine(middleX, middleY, middleX, stickbot);
		
	if(randomcolour == true){					//random colour generator. Set AFTER
												//the stick colour setter.
		float r = (float)Math.random();
		float g = (float)Math.random();
		float b = (float)Math.random();
		Color col=new Color(r,g,b);
		UI.setColor(col);}
		
	else {UI.setColor(Color.red);}				//if random colours are not used, it
												//will always default to red oval
	UI.fillOval(x, y, wd, wd);
	
	}}

