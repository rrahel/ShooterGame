package at.fhj.sodevel2.shooter.model;

import java.awt.Rectangle;

public class Alien extends SpaceObj {

	

	public Alien(int X, int Y) {
		super(X, Y);

	}

	// getting coordinates from SpaceObj for the Alien
	public void move() {

		super.setX(super.getX() - 10);
	}
	//creating a square for the collision method
	public Rectangle getBounds() {

		return super.getBounds();
	}

}
