package at.fhj.sodevel2.shooter.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private BufferedImage image;;

	// loads images from the res folder and the images are compressed in the jar
	// file
	public BufferedImage loadImage(String path) {

		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;

	}

}
