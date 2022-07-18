package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Stats  {
	
	
	
	protected BufferedImage image; 
	protected int x, y; 
	protected int cost; 
	public Stats(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public abstract void paint(Graphics g);
	public abstract void action(Dots dot);
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}//end of class 
