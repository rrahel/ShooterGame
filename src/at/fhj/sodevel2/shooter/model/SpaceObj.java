package at.fhj.sodevel2.shooter.model;

import java.awt.Rectangle;

public class SpaceObj {

	protected int x;
	protected int y;
	int WIDTH = 20;
	int HEIGHT = 20;

	public SpaceObj(int X, int Y) {

		this.x = X;
		this.y = Y;
	}
	//getter and setter for x and y
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public void moveX(int a) {

		int move = this.x + a;
		this.x = move;

	}

	public void moveY(int b) {

		int move = this.y + b;
		this.y = move;

	}
	//creating a square for the collision method
	public Rectangle getBounds() {

		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

}
