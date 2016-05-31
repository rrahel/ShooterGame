package at.fhj.sodevel2.shooter.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import at.fhj.sodevel2.shooter.model.Space;
import at.fhj.sodevel2.shooter.model.Alien;
import at.fhj.sodevel2.shooter.model.Missile;
import at.fhj.sodevel2.shooter.model.SpaceShip;

public class GameWorld extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpaceShip ship;

	// ich verwende CopyOnWriteArrayList um den Fehler
	// "java.util.ConcurrentModificationException" zu vermeiden
	private CopyOnWriteArrayList<Missile> missile;
	private CopyOnWriteArrayList<Alien> alien;
	private CopyOnWriteArrayList<Space> space;
	private int score = 0;
	private BufferedImage spaceship = null;
	private BufferedImage greenmissile = null;
	private BufferedImage AlienPic = null;
	private BufferedImage StarPic = null;

	public GameWorld() {
		super();
		this.ship = new SpaceShip(100, 200);
		missile = new CopyOnWriteArrayList<Missile>();
		alien = new CopyOnWriteArrayList<Alien>();
		space = new CopyOnWriteArrayList<Space>();

	}

	// das score funktion
	public int getScore() {
		return score;
	}

	// paint Methode

	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.BLACK);

		// loading star image
		BufferedImageLoader Starloader = new BufferedImageLoader();
		StarPic = Starloader.loadImage("/star.jpg");
		// generating random stars
		Random rand = new Random();

		space.add(new Space(700 + 10, 500 - rand.nextInt(500)));

		// painting the stars
		for (Space s : space) {
			g.drawImage(StarPic, s.getX(), s.getY(), null);
			s.move();

		}

		// painting Score
		g.setColor(Color.RED);
		g.setFont(new Font("Verdana", Font.BOLD, 30));
		g.drawString("Score: " + String.valueOf(getScore()), 10, 30);

		// loading the ship image
		BufferedImageLoader loader = new BufferedImageLoader();
		spaceship = loader.loadImage("/shipPic.png");
		// painting the ship
		g.drawImage(spaceship, ship.getX() - 50, ship.getY() - 12, null);

		// loading the missile image
		BufferedImageLoader Missloader = new BufferedImageLoader();
		greenmissile = Missloader.loadImage("/missilePic.png");
		// painting the missile
		for (Missile m : missile) {
			g.drawImage(greenmissile, m.getX(), m.getY(), null);
			m.move();
		}

		// loading the alien image
		BufferedImageLoader Alienloader = new BufferedImageLoader();
		AlienPic = Alienloader.loadImage("/alienPic.png");
		// generate random aliens
		Random r = new Random();
		if (r.nextInt(99) > 90) {
			alien.add(new Alien(800 + 10, 600 - r.nextInt(590)));
		}
		// painting the aliens
		for (Alien a : alien) {
			g.drawImage(AlienPic, a.getX(), a.getY(), null);
			a.move();

		}

	}

	public SpaceShip getSpaceShip() {
		return ship;
	}

	public void addMissile(Missile m) {
		this.missile.add(m);
	}

	// Collision detection
	public void checkCollision() {

		// collision ship mit alle aliens
		Rectangle shipRec = ship.getBounds();
		for (int j = 0; j < alien.size(); j++) {
			Alien a = alien.get(j);
			Rectangle alienRec = a.getBounds();
			// ob das Ship collidiert mit alien das spiel ender und zeigt
			// "Game Over"
			if (shipRec.intersects(alienRec)) {

				// System.out.println("collison ship mit alien");
				
				  JOptionPane.showMessageDialog(this, "Your score is: " +
				  getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
				  System.exit(ABORT);
				 
			}

		}

		// collision missiles mit aliens
		for (int i = 0; i < missile.size(); i++) {
			Missile m = missile.get(i);
			Rectangle missileRec = m.getBounds();

			for (int j = 0; j < alien.size(); j++) {
				Alien a = alien.get(j);
				Rectangle alienRec = a.getBounds();
				// missile und alien loschen wenn kolision passiert
				// score +1 addieren wenn missile und alien kolidieren
				if (missileRec.intersects(alienRec)) {
					alien.remove(j);
					missile.remove(i);
					score++;

				}

			}

		}

	}

}
