package at.fhj.sodevel2.shooter.model;

public class Space extends SpaceObj {

	public Space(int X, int Y) {
		super(X, Y);

	}

	
	public void move() {

		super.setX(super.getX() - 2);
	}

}
