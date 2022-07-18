package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class SaveGame {

	
	private int x; 
	private int y; 
	private BufferedImage image; 
	public SaveGame(int x, int y) {
		this.x=x; 
		this.y=y; 
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTESAVEGAME));

		} catch (IOException ex) {
			System.err.println("No se pudo cargar la imagen del Dot");
		} // try-catch
		// TODO Auto-generated constructor stub
	}

	
	public void paint(Graphics g) {
		g.drawImage(image, this.x, this.y, null); 
		
	}


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

	
	

}//end of class 
