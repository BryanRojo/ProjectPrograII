package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
	
	
	
	private int sizeX; 
	private int sizeY; 
	private Square squares[][]; 
	public Board(int x, int y ) {
		this.sizeX=x; 
		this.sizeY=y; 
		this.squares= new Square[sizeX][sizeY]; 
		this.initializeSquares();
		this.createDots();
		this.createDotsMana();
	}//end of constructor 
	public Board(int x, int y, Square squares[][] ) {
		this.sizeX=x; 
		this.sizeY=y; 
		this.squares= squares; 
		//this.createDotsMana();
	}//end of constructor 
	
	private void  initializeSquares() {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				this.squares[i][j]= new Square(i, j); 
			}
		}
	}//end of initializeSquares()
	
	public void draw(Graphics g) {
		
		
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				
					this.squares[i][j].draw(g);
				
			}
		}
		
	}//end of draw
	
	private void createDots() {
		
		int cantDots= this.sizeX/5-1; 
		for (int i = 0; i < squares.length; i++) {
			
			if (i%5==0&&i>0) {
				this.squares[i-1][0].createDot(i-1, 0, 2);
				this.squares[i-1][this.sizeX-1].createDot(i-1, this.sizeX-1, 1);
			}
			
		}//end of for 
		
	}//end of createDots
	
	private void createDotsMana() {
		int num= (this.sizeX/5)-1; 
		if (num%2==0) {
			this.createDotsManaPar();
		}else {
			this.createDotsManaImpar();
		}
	}
	private void createDotsManaPar() {
		 ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int x, y; 
		int num= (this.sizeX/5)-1; 
		int control=1; 
		boolean create; 
		for (int i = 1; i <= num;  i++) {
			create=false; 
			while (!create) {
				
					if (control==1) {
						x=tlr.nextInt(0, (this.sizeX/2));
						y=tlr.nextInt(0, this.sizeY);
						if (!this.getSquares()[y][x].manaBox()) {
							this.getSquares()[y][x].createDotMana(y, x); 
							create=true;
						}
					}
					if (control==-1) {
						x=tlr.nextInt((this.sizeX/2),this.sizeX );
						y=tlr.nextInt(0, this.sizeY);
						if (!this.getSquares()[y][x].manaBox()) {
							this.getSquares()[y][x].createDotMana(y, x); 
							create=true;
						}
					}
					
				
				
			}//fin de while
			control=control*-1; 
		}//end of for 
	}//end of createDotsMana()
	private void createDotsManaImpar() {
		 ThreadLocalRandom tlr = ThreadLocalRandom.current();
		int x, y; 
		int num= (this.sizeX/5)-1; 
		int control=1; 
		boolean create; 
		for (int i = 1; i <= num;  i++) {
			create=false; 
			while (!create) {
				if (i%3==0) {
					x=(this.sizeX/2)-1;
					y=tlr.nextInt(0, this.sizeY);
					if (!this.getSquares()[y][x].manaBox()) {
						this.getSquares()[y][x].createDotMana(y, x); 
						create=true;
					}
					
				}else {
					if (control==1) {
						x=tlr.nextInt(0, (this.sizeX/2));
						y=tlr.nextInt(0, this.sizeY);
						if (!this.getSquares()[y][x].manaBox()) {
							this.getSquares()[y][x].createDotMana(y, x); 
							create=true;
						}
					}
					if (control==-1) {
						x=tlr.nextInt((this.sizeX/2),this.sizeX );
						y=tlr.nextInt(0, this.sizeY);
						if (!this.getSquares()[y][x].manaBox()) {
							this.getSquares()[y][x].createDotMana(y, x); 
							create=true;
						}
					}
					
				}
				
			}//fin de while
			control=control*-1; 
		}//end of for 
	}//end of createDotsMana()

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

}//end of class 
