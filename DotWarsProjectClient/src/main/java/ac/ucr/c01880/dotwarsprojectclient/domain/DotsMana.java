package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class DotsMana {
	
	private int x; 
	private int y; 
	private BufferedImage image; 
	
	public DotsMana(int x, int y ) {
		this.x=x; 
		this.y=y; 
		
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEDOTSMANA));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end of constructor 
	
	public void draw(Graphics g) {
		g.drawImage(image, x*20, y*20,  null);
	}

}//end of class 
