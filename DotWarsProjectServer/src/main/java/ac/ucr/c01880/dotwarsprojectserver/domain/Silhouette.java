package ac.ucr.c01880.dotwarsprojectserver.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectserver.utility.Route;
import java.io.File;


public class Silhouette {

    private int x, y;
    private BufferedImage image;

    public Silhouette(int x, int y) {
        this.x = x;
        this.y = y;
        try {

            File file = new File(Route.ROUTESILHOUETTE);
            this.image = ImageIO.read(file);

        } catch (IOException ex) {
            System.err.println("No se pudo cargar la imagen del Dot");
        } // try-catch
	}//end of class
	
	public void draw(Graphics g) {
		g.drawImage(this.image, x*40, y*40,null); 
	}

}//end of class
