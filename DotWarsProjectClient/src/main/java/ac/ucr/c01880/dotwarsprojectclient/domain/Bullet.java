package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;

public class Bullet extends Thread {
	private boolean suspend; 
	private int x; 
	private int y; 
	private Dots dot; 
	private BufferedImage image; 
	private int m; 
	private int b; 
	public Bullet(Dots dot ) {
		this.x= dot.getX(); 
		this.y= dot.getY(); 
		
		
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(Route.ROUTEBULLET));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end of constrcutor 
	public void paint(Graphics g) {
		g.drawImage(image, x*20, y*20,  null); 
	}//end of draw(Graphics g)
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				
				
				this.y+=m*0.006;
				this.x+=b*0.006;
				if (dot.getY()+dot.getAttackRange()==this.y
				) {
					this.resetCordenates();
					this.suspend=true; 
				}
				

				synchronized (this) {
					if (suspend) {
						wait();
					}
				}
			
				
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}//end of run
	
	public void resetCordenates() {
		this.x= dot.getX(); 
		this.y= dot.getY(); 
	}//end of resetCordenates()
	
	
	public synchronized void suspendThread() {
		this.suspend=true;
	}
	public synchronized void resumeThread() {
		this.suspend=false;
		notify();
	}
	public int damage() {
		return this.dot.getAttackPoints(); 
	}
	public int getType() {
		return this.dot.getType(); 
	}
	public void directionShotGun(int xMause, int yMause) {
		this.m=(yMause-this.y);
		this.b=(xMause-this.x);
		
		
	}//end of directionShotGun(int xMause, int yMause)
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
