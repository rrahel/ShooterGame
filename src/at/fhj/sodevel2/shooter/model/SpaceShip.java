package at.fhj.sodevel2.shooter.model;

import java.awt.Rectangle;

public class SpaceShip extends SpaceObj {
	//getting x and y from spaceobj class
	public SpaceShip(int X, int Y) {
		super(X, Y);

	}
	//creating a square for the collision method
	public Rectangle getBounds() {

		return super.getBounds();
	}

}
