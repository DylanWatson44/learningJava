package bugWorld;
import javafx.scene.shape.Circle;


public class playerBug extends Circle implements MovingObjects{

	private static final float MAX_SPEED= 10f;
	private static final float BASE_SPEED=2f;
	private float dx = 1.2f;
	private float dy = 0f;
	public playerBug(int i, int j, int k){
		super(i,j,k);
	}
	public float getMaxSpeed() {
		return MAX_SPEED;
	}
	public void moveRight(){
		setDx(BASE_SPEED);
		setDy(0f);
	}
	public void moveLeft(){
		setDx(-BASE_SPEED);
		setDy(0f);
	}
	public void moveUp(){
		setDx(0f);
		setDy(-BASE_SPEED);
	}
	public void moveDown(){
		setDx(0f);
		setDy(BASE_SPEED);
	}
	public float getDx() {
		return dx;
	}
	public void setDx(float dx) {
		this.dx = dx;
	}
	public float getDy() {
		return dy;
	}
	public void setDy(float dy) {
		this.dy = dy;
	}
}
