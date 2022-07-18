package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;
import java.io.File;

public class Strength extends Stats {

    public Strength(int x, int y) {
        super(x, y);
        this.cost = 2;
        try {

            File file = new File(Route.ROUTESTRENGTH);
            this.image = ImageIO.read(file);
        } catch (IOException ex) {
            System.err.println("No se pudo cargar la imagen del Dot");
        } // try-catch
        // TODO Auto-generated constructor stub
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, this.x, this.y, null);

    }

    @Override
    public void action(Dots dot) {
        dot.setAttackPoints(dot.getAttackPoints() + 1);

    }

}//end of class 
