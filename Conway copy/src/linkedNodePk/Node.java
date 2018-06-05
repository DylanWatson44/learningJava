package linkedNodePk;

import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

public class Node extends Rectangle {

	private Node NorthNode;
	private Node EastNode;
	private Node SouthNode;
	private Node WestNode;

	private boolean LivingStatus = false;
	private boolean NextGenStatus = false;
	private boolean HasBeenChecked = false;

	public Node(double xPos, double yPos) {
		super(xPos, yPos, 9, 9);
		setFill(Color.BLACK);
		this.setStatus(false);
		this.setNextGenStatus(false);

	}
	
	public void updateCells(){
        setStatus(getNextGenStatus());
        if(getStatus()){
            setAlive();
        }
        else{
            setFill(Color.BLACK);
        }
        setHasBeenChecked(false);
    }

    public void setAlive(){
    	setStatus(true);
        setFill(Color.ORANGE);
    }

	public Node getNorthNode() {
		return NorthNode;
	}

	public void setNorthNode(Node northNode) {
		NorthNode = northNode;
	}

	public Node getEastNode() {
		return EastNode;
	}

	public void setEastNode(Node eastNode) {
		EastNode = eastNode;
	}

	public Node getSouthNode() {
		return SouthNode;
	}

	public void setSouthNode(Node southNode) {
		SouthNode = southNode;
	}

	public Node getWestNode() {
		return WestNode;
	}

	public void setWestNode(Node westNode) {
		WestNode = westNode;
	}

	public boolean getStatus() {
		return LivingStatus;
	}

	public void setStatus(boolean status) {
		LivingStatus = status;
		if(LivingStatus)
			setFill(Color.ORANGE);
	}

	public boolean getNextGenStatus() {
		return NextGenStatus;
	}

	public void setNextGenStatus(boolean nextGenStatus) {
		NextGenStatus = nextGenStatus;
	}

	public boolean getHasBeenChecked() {
		return HasBeenChecked;
	}

	public void setHasBeenChecked(boolean hasBeenChecked) {
		HasBeenChecked = hasBeenChecked;
	}

}
