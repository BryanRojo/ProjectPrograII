package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;
import java.io.File;

public class Life extends Stats {

	
	

	public Life(int x, int y) {
		
		super(x, y);
		this.cost=1; 
	           try {
                File file = new File(Route.ROUTELIFE);
                this.image = ImageIO.read(file);


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
		dot.setLifePoints(dot.getLifePoints()+1);
		
	}

}//end of class 
