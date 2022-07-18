package ac.ucr.c01880.dotwarsprojectclient.domain;

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
        this.logic = new Logic();

    }

    public static SingletonControllerGame getIntance() {
        if (instance == null) {
            instance = new SingletonControllerGame();

        }
        return instance;
    }

    public void impactDot(int mouseX, int mouseY) {
        this.game.impactDot(mouseX, mouseY);

    }//end of impactDot(int mouseX, int mouseY)

    public void impacSurrender(int mouseX, int mouseY) {
        if (this.logic.impactSurrender(mouseX, mouseY, this.game.getSurrender())) {
            //this.controler.getWindowS().dispose();
            if ((int) (this.game.getGameTurn() / 100) == 1) {
                JOptionPane.showMessageDialog(null, "Ganan las rojas");
            } else {
                JOptionPane.showMessageDialog(null, "Ganan las azules");
            }

        }
    }

    public void movDotRight(int iDots, int jDots) {
        this.game.movDotRight(iDots, jDots);

    }//end of movDotRight()

    public void movDotUp(int iDots, int jDots) {
        this.game.movDotUp(iDots, jDots);
    }

    public void movDotDown(int iDots, int jDots) {
        this.game.movDotDown(iDots, jDots);

    }

    public void movDotLeft(int iDots, int jDots) {
        this.game.movDotLeft(iDots, jDots);

    }

    public void movSendRight() {
        this.client.SendMessage(this.client.getName() + ":" + Route.MOVRIGTH + ":" + this.game.getiDots() + ":" + this.game.getjDots());
    }

    public void movSendLeft() {
        this.client.SendMessage(this.client.getName() + ":" + Route.MOVLEFT + ":" + this.game.getiDots() + ":" + this.game.getjDots());
    }

    public void movSendUp() {
        this.client.SendMessage(this.client.getName() + ":" + Route.MOVUP + ":" + this.game.getiDots() + ":" + this.game.getjDots());
    }

    public void movSendDown() {
        this.client.SendMessage(this.client.getName() + ":" + Route.MOVDOWN + ":" + this.game.getiDots() + ":" + this.game.getjDots());
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
