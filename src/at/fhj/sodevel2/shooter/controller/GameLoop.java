package at.fhj.sodevel2.shooter.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import at.fhj.sodevel2.shooter.model.Missile;
import at.fhj.sodevel2.shooter.model.SpaceShip;
import at.fhj.sodevel2.shooter.view.GameWorld;

public class GameLoop implements KeyListener, Runnable {
	

	private boolean isRunning;
	private GameWorld world;

	public void setGameWorld(GameWorld Game) {
		world = Game;

	}

	public void keyPressed(KeyEvent k) {

		// if you press the arrow right the ship increase x ++20 till at width
		// 660 where it stops moving
		SpaceShip ship = world.getSpaceShip();
		int myKey = k.getKeyCode();
		if (myKey == KeyEvent.VK_RIGHT) {
			if (ship.getX() < 660)
				ship.moveX(20);
			else
				ship.moveX(0);

		}
		// if you press the arrow left the ship decrease x --20 till at width 40
		// where it stops moving
		if (myKey == KeyEvent.VK_LEFT) {
			if (ship.getX() > 40)
				ship.moveX(-20);
			else
				ship.moveX(0);

		}
		// if you press the arrow up the ship decrease x --20 till at height 25
		// where it stops moving
		if (myKey == KeyEvent.VK_UP) {
			if (ship.getY() > 25)
				ship.moveY(-20);
			else
				ship.moveY(0);
		}
		// if you press the arrow down the ship increase x ++20 till at height
		// 455 where it stops moving
		if (myKey == KeyEvent.VK_DOWN) {
			if (ship.getY() < 455)
				ship.moveY(20);
			else
				ship.moveY(0);
		}
		// if you oress space the ship fires a missile
		if (myKey == KeyEvent.VK_SPACE) {
			Missile m = new Missile(world.getSpaceShip().getX() + 20, world
					.getSpaceShip().getY());

			world.addMissile(m);
		}

		world.repaint();

	}

	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub

	}

	public GameLoop() {
		this.isRunning = true;
	}

	public void stopGame() {
		this.isRunning = false;
	}

	public boolean isRunning() {

		return isRunning;
	}

	// interface Runnable
	// thread
	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(30);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			world.repaint();
			world.checkCollision();
			// System.out.println("Repaint?");
		}
	}
}
