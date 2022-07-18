package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class DotsFlag {
	private int x; 
	private int y; 
	private BufferedImage image;
	public DotsFlag(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		
		try {
			
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEDOTSBLUEFLAG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of class 
	
	public void paint(Graphics g) {
		g.drawImage(image, x, y, null); 
		
	}//end of class 
	public void changeImageOne() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEDOTSBLUEFLAG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void changeImageTwo() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEDOTSREDFLAG));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}//end of class 
