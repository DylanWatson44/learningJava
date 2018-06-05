import javafx.scene.shape.Circle;

public class MyCircle extends Circle {
	private float x = 100, y = 100;
	private float dx = -5f;
	private float dy = -5f;

	public MyCircle(int i, int j, int k) {
		super(i, j, k);
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
