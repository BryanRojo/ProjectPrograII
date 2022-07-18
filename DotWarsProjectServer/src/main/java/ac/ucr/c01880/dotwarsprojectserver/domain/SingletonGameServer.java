package ac.ucr.c01880.dotwarsprojectserver.domain;

public class SingletonGameServer {
	private Game game; 
	private static SingletonGameServer instance; 
	
	
	public SingletonGameServer() {
		this.game= new Game(); 
	}//end of class
	
	public static SingletonGameServer getIntance() {
		if (instance==null) {
			instance= new SingletonGameServer(); 
			
		}
		return instance; 
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}//end of class 
