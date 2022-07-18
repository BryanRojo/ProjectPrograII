package ac.ucr.c01880.dotwarsprojectclient.bussiness;

import ac.ucr.c01880.dotwarsprojectclient.domain.Bullet;
import ac.ucr.c01880.dotwarsprojectclient.domain.Dots;
import ac.ucr.c01880.dotwarsprojectclient.domain.NeverSurrender;
import ac.ucr.c01880.dotwarsprojectclient.domain.SaveGame;
import ac.ucr.c01880.dotwarsprojectclient.domain.Stats;

public class Logic {
	
	
	public Logic() {
		// TODO Auto-generated constructor stub
	}
	

	public boolean impactSurrender(int x, int y, NeverSurrender surrender) {
		if (((surrender.getX())<=x)&&((surrender.getX())+40>=x)&&
				((surrender.getY())<=y)&&((surrender.getY())+40>=y)) {
			
			return true;
		}
		
		return false; 
	}//end of impactSurrender(int x, int y, NeverSurrender surrender)
	public boolean impactDot(Dots dot, int x, int y) {
		if (((dot.getX()*20)<=x)&&((dot.getX()*20)+20>=x)&&
				((dot.getY()*20)<=y)&&((dot.getY()*20)+20>=y)) {
			System.out.println(dot.getX()*20+"dot x"+" x de mouse");
			System.out.println(dot.getY()*20+"dot y"+" y de mouse");
			return true;
		}
		
		return false; 
	}
	
	public boolean impactStats(Stats stat, int x, int y) {
		if (((stat.getX())<=x)&&((stat.getX())+40>=x)&&
				((stat.getY())<=y)&&((stat.getY())+40>=y)) {
			
			return true;
		}
		
		return false; 
	}
	public boolean impactSaveGame(SaveGame saveGame, int x, int y) {
		if (((saveGame.getX())<=x)&&((saveGame.getX())+40>=x)&&
				((saveGame.getY())<=y)&&((saveGame.getY())+40>=y)) {
			
			return true;
		}
		
		return false; 
	}
	public boolean impactBulletDot(Dots dot, Bullet bullet) {
		if (dot.getType()!=bullet.getType()) {
			if (((dot.getX())<=bullet.getX())&&((dot.getX())+40>=bullet.getX()+10)&&
					((dot.getY())<=bullet.getY())&&((dot.getY())+40>=bullet.getY()+10)) {
				
				return true;
			}//end of two if 
		}//end of one if 
		
		
		
		return false; 
	}

}//end of class
