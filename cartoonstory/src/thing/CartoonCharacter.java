package thing;
import ecs100.UI;
public class CartoonCharacter {
	//fields
	private double figX;
	private double figY;
	private String direction = "right";
	private String emotion = "smile";
	private String imageFolder;
	private double wd = 60;
	private double ht = 80;

	//constructor
	public CartoonCharacter(double x, double y, String base){
		this.imageFolder=base;
		this.figX = x;
		this.figY = y;
		this.draw();
	}

	public void lookLeft(){
		this.erase();
		this.direction = "left";
		this.draw();
	}
	public void lookRight(){
		this.erase();
		this.direction = "right";
		this.draw();	 
	}
	public void frown(){
		this.erase();
		this.emotion = "frown";
		this.draw();
	}
	public void smile(){
		this.erase();
		this.emotion = "smile";
		this.draw();
	}
	public void walk(double dist){
		this.erase();
		if (this.direction.equals("right")){
			this.figX = this.figX + dist;
		}
		else{this.figX = this.figX - dist;}
		this.draw();
	}
	public void speak(String msg){
		double bubX= this.figX;
		double bubY= this.figY -60;
		UI.drawOval(bubX, bubY, 50, 50);
		UI.drawString(msg, bubX+9, bubY+30);
		UI.sleep(500);
		UI.eraseOval(bubX, bubY, 50, 50);
	}
	public void erase(){
		UI.eraseRect(this.figX, this.figY, this.wd, this.ht);
	}
	public void draw(){
		String filename = this.imageFolder + "/" + this.direction + "-" + this.emotion + ".png";
		UI.drawImage(filename, this.figX, this.figY, this.wd, this.ht);
		UI.sleep(100);
	}

}//class
