package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;
import java.io.File;

public class NeverSurrender {

    private int x, y;
    private BufferedImage image;

    public NeverSurrender(int x, int y) {
        this.x = x;
        this.y = y;
        try {

            File file = new File(Route.ROUTENEVERSURENDER);
            this.image = ImageIO.read(file);

        } catch (IOException ex) {
            System.err.println("No se pudo cargar la imagen del NeverSurrender");
        } // try-catch

    }//end of constructor 

    public void paint(Graphics g) {
        g.drawImage(image, x, y, null);
    }//end of paint 
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
