package at.fhj.sodevel2.shooter.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import at.fhj.sodevel2.shooter.controller.GameLoop;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameWindow() {
		// das JFrame Fenster bauen
		this.setTitle("SpaceShooter");
		this.setSize(700, 500);
		this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameWorld gameW = new GameWorld();
		GameLoop gameL = new GameLoop();
		gameL.setGameWorld(gameW);
		this.addKeyListener(gameL);
		this.getContentPane().add(gameW, BorderLayout.CENTER);
		this.setVisible(true);

		Thread t = new Thread(gameL);
		t.start();
	}

}
