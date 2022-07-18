package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class Attack extends Stats{

	public Attack(int x, int y) {
		super(x, y);
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEATTACK));

		} catch (IOException ex) {
			System.err.println("No se pudo cargar la imagen del Dot");
		} // try-catch
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, this.x, this.y, null);
		
	}

	@Override
	public void action(Dots dot) {
		SingletonControllerGame.getIntance().getGame().setShotGun(true);
		
		
		
	}

}//end of class
