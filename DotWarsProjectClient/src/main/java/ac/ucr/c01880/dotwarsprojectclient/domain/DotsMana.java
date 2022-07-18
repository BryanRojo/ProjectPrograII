package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;
import java.io.File;

public class DotsMana {

    private int x;
    private int y;
    private BufferedImage image;

    public DotsMana(int x, int y) {
        this.x = x;
        this.y = y;

        try {

            File file = new File(Route.ROUTEDOTSMANA);
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of constructor 

    public void draw(Graphics g) {
        g.drawImage(image, x * 20, y * 20, null);
    }

}//end of class 
