package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import ac.ucr.c01880.dotwarsprojectclient.bussiness.Client;
import ac.ucr.c01880.dotwarsprojectclient.bussiness.Controller;
import ac.ucr.c01880.dotwarsprojectclient.bussiness.Logic;
import ac.ucr.c01880.dotwarsprojectclient.utility.Route;



public class SingletonControllerGame {
	private static SingletonControllerGame instance; 
	private Game game; 
	private Logic logic; 
	private Client client; 
	
	private Controller controler; 
	private SingletonControllerGame() {
		this.logic= new Logic(); 
		
	}
	
	public static SingletonControllerGame getIntance() {
		if (instance==null) {
			instance= new SingletonControllerGame(); 
			
		}
		return instance; 
	}
	public void impactDot(int mouseX, int mouseY) {
		this.game.impactDot(mouseX, mouseY);
	
		
	}//end of impactDot(int mouseX, int mouseY)
	public void impacSurrender(int mouseX, int mouseY) {
		if(this.logic.impactSurrender(mouseX, mouseY, this.game.getSurrender())){
			//this.controler.getWindowS().dispose();
			if ((int)(this.game.getGameTurn()/100)==1) {
				JOptionPane.showMessageDialog(null,"Ganan las rojas");
			}else {
				JOptionPane.showMessageDialog(null,"Ganan las azules");
			}
			
		}
	}
	public void movDotRight(int iDots, int jDots) {
		this.game.movDotRight(iDots, jDots);
		
//		this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().setX(
//				this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().getX()+1);
//		this.game.getBoard().getSquares()[this.game.getiDots()+1][this.game.getjDots()].setDot(
//				this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot()
//				);
//		this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].setDot(null); 
		
	}//end of movDotRight()
	public void movDotUp(int iDots, int jDots) {
		this.game.movDotUp(iDots, jDots);
//		this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().setY(
//				this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().getY()-1);
	}
	public void movDotDown(int iDots, int jDots) {
		this.game.movDotDown(iDots, jDots);
//		this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().setY(
//				this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().getY()+1);
	}
	public void movDotLeft(int iDots, int jDots) {
		this.game.movDotLeft(iDots, jDots);
//		this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().setX(
//				this.game.getBoard().getSquares()[this.game.getiDots()][this.game.getjDots()].getDot().getX()-1);
	}
//	public void saveGame(int x, int y ) throws FileNotFoundException, ClassNotFoundException, IOException {
//		
//		
//		if (this.logic.impactSaveGame(this.game.getSaveGame(),x, y)) {
//			
//			GameStructureData game= new GameStructureData(this.game.getiDots(),
//					this.game.getjDots(),
//					this.game.getPassword(), 
//					this.game.testMov(), 
//					this.game.getGameTurn(), 
//					this.game.isShotGun(), 
//					this.game.getPointRed(),
//					this.game.getPointBlue(), 
//					this.game.getAux(), 
//					this.game.isSelectedDot(),
//					this.game.isSelected(),
//					this.game.createDotsOcupation()
//					);  
//			if (this.businessGameData.getUserAccount(this.game.getPassword())!=null) {
//				this.businessGameData.upDateAccount(game);
//				
//			}else {
//				this.businessGameData.registerAccount(game);
//			}
//			
//			
//		}
//		
//		
//		
//	}
//	public GameStructureData getGames(String password ) throws FileNotFoundException, ClassNotFoundException, IOException {
//		return this.businessGameData.getUserAccount(password); 
//	}
	
	public void movSendRight() {
		this.client.SendMessage(this.client.getName()+":"+Route.MOVRIGTH+":"+this.game.getiDots()+":"+this.game.getjDots());
	}
	public void movSendLeft() {
		this.client.SendMessage(this.client.getName()+":"+Route.MOVLEFT+":"+this.game.getiDots()+":"+this.game.getjDots());
	}
	public void movSendUp() {
		this.client.SendMessage(this.client.getName()+":"+Route.MOVUP+":"+this.game.getiDots()+":"+this.game.getjDots());
	}
	public void movSendDown() {
		this.client.SendMessage(this.client.getName()+":"+Route.MOVDOWN+":"+this.game.getiDots()+":"+this.game.getjDots());
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Logic getLogic() {
		return logic;
	}

	public void setLogic(Logic logic) {
		this.logic = logic;
	}

	public Controller getControler() {
		return controler;
	}

	public void setControler(Controller controler) {
		this.controler = controler;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}//end of class 
