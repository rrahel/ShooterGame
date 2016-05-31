package at.fhj.sodevel2.shooter.model;

import java.awt.Rectangle;


public class Missile extends SpaceObj {

	
	
	//getting coordinates for missile from spaceobj
	public Missile(int X, int Y) {
		super(X, Y);

	}

	public void move() {
		super.setX(super.getX() + 30);
	}
	//creating a square for the collision method
	public Rectangle getBounds() {
		
		return new Rectangle(getX(),getY(), 50, 50);
	}
	
	

}
