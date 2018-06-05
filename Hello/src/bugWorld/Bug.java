package bugWorld;

import java.util.ArrayList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * @author watsondyla
 * @version 1.0
 * 
 * Abstract class used to create bugs, which are actually extensions of the Circle class in Javafx
 * and implements the MovingObjects interface
 * 
 */

public abstract class Bug extends Circle implements MovingObjects {

	// fields
	private float x = 100, y = 100;
	private float dx = -2f;
	private float dy = -2f;
	private boolean alive = true;
	private double energy = 1200;
	private boolean isColliding = false;
	private static final float MAX_SPEED = 5f;
	private static final float NORMAL_SPEED = 1f;

	// constructor
	public Bug(int i, int j, int k) {
		super(i, j, k);
		// boundaries = new Bounds()
	}

	// setters
	public void setDx(float dx) {
		this.dx = dx;
	}
	public void setDy(float dy) {
		this.dy = dy;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void setAlive(boolean bol) {
		this.alive = bol;
	}
	public void setColliding(boolean b) {
		isColliding =b;
	}
	
	//getters
	public float getDx() {
		return dx;
	}
	public float getDy() {
		return dy;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public float getMaxSpeed() {
		return MAX_SPEED;
	}
	public boolean isColliding() {
		return isColliding;
	}
	public boolean checkAlive() {
		return alive;
	}
	
	/**
	 * Method to reset the speed
	 * <p>
	 * Takes it current velocity and modifies it so that it keeps going in the right direction,
	 * but at a (usually) reduced speed.
	 * 
	 * 
	 */
	public void setNormalSpeed() {
		if (dx > 0) {
			dx = NORMAL_SPEED;
		} else
			dx = -NORMAL_SPEED;
		if (dy > 0) {
			dy = NORMAL_SPEED;
		} else
			dy = -NORMAL_SPEED;
	}

	/**
	 * Collision detector. 
	 * <p>
	 * Creates a new shape which is the sum of the intersecting part of two shapes.
	 * If the new shapes width is 0, it means there's no intersection and therefore no collision.
	 * <p>
	 * @param s
	 * Current bug
	 * @param z
	 * Other shape in question
	 * @return boolean: colliding or not colliding 
	 */
	public static boolean checkCollision(Shape s, Shape z) {
		Shape sumOfTwoShapes = Shape.intersect(s, z);
		if (sumOfTwoShapes.getBoundsInParent().getWidth() != -1) {
			((Bug) s).setColliding(true);
			if (z instanceof Bug) {
				((Bug) z).setColliding(true);
			}
			return true;
		}
		return false;
	}

//Collision detection for a bug on the player. 
	public boolean checkPlayerCollision(Shape s, Shape player) {
		Shape sumOfTwoShapes = Shape.intersect(s, player);
		if (sumOfTwoShapes.getBoundsInParent().getWidth() != -1) {
			return true;
		} else
			return false;
	}

//"Kill" a bug method
	public void killBug() {
		setFill(Color.GREY);
		dx = 0;
		dy = 0;
		setAlive(false);
	}
//Bugs have limited energy	
	public void expendEnergy() {
		energy -= 1;
		if (energy == 0)
			killBug();
	}
//Bugs can replenish their energy
	public void eatPlant() {
		energy += 400;
		setScaleX(getScaleX() + 0.1);
		setScaleY(getScaleY() + 0.1);
	}

	//Manual movement
	public static void moveRight(Bug p) {
		p.setDx(Math.abs(p.getDx()));
	}
	public static void moveLeft(Bug p) {
		p.setDx(-Math.abs(p.getDx()));
	}
	public static void moveUp(Bug p) {
		p.setDy(-Math.abs(p.getDy()));
	}
	public static void moveDown(Bug p) {
		p.setDy(Math.abs(p.getDy()));
	}
}
