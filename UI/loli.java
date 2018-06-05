import ecs100.UI;
import java.awt.Color;
public class loli {

public static final double size=UI.askDouble("Diameter:");
public static final double middleX= 300 + size/2;
public static final double middleY= 100 + size/2;
public static final double stickbot = middleY + UI.askDouble("Length:"); 

	
	public void lolidrawing(){
		double edgeX = middleX -size/2;
		double edgeY = middleY -size/2;
	
		UI.setLineWidth(5);
		UI.setColor(Color.black);
		UI.drawLine(middleX, middleY, middleX, stickbot);
		
		UI.setColor(Color.red);
		
		UI.fillOval(edgeX, edgeY, size, size);
		
	
	}



	

}
