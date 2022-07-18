package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class Move extends Stats {

	
	

	public Move(int x, int y) {
		super(x, y);
		this.cost=2; 
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEMOVE));

		} catch (IOException ex) {
			System.err.println("No se pudo cargar la imagen del Dot");
		} // try-catch
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, this.x, this.y,  null);
		
	}

	@Override
	public void action(Dots dot) {
		dot.setWalkingSteps(dot.getWalkingSteps()+1); 
		
	}

}//end of class 
