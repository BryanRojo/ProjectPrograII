package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Color;
import java.awt.Graphics;





public class Square  {
	
	private Dots dot; 
	private DotsMana dotsMana; 
	private int x,y; 
	public Square(int x, int y) {
		this.x= x; 
		this.y=y; 
		
	}//end of Square 
	
	public void createDot(int x, int y, int type ) {
		this.dot= new Dots(x , y, type); 
	}
	public void createDotMana(int x, int y) {
		this.dotsMana= new DotsMana(x , y); 
	}
	public void draw(Graphics g ) {
		if (this.dot!=null) {
			this.dot.draw(g);
		}
		if (this.dotsMana!=null) {
			this.dotsMana.draw(g);
		}
		g.setColor(new Color(145,96,165));
			g.drawRect(x*20, y*20, 20, 20);
		
		
	}//end of dibujar(Graphics g )
	public boolean fullSquare() {
		return this.dotsMana!=null&&this.dot!=null; 
	}
	public boolean manaBox(){
		return this.dotsMana!=null; 
	}
	
	
	public boolean  emptySquare() {
		return this.dot!=null; 
	}

	public Dots getDot() {
		return dot;
	}

	public void setDot(Dots dot) {
		this.dot = dot;
	}

	public DotsMana getDotsMana() {
		return dotsMana;
	}

	public void setDotsMana(DotsMana dotsMana) {
		this.dotsMana = dotsMana;
	}

	
	
}//end of class 
