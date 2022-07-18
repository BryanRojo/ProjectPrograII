package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class GameStructureData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int iDots, jDots;
    private String password;
    private int[][] MatLogic;
    private int gameTurn;
    private boolean shotGun;
    private int pointRed, pointBlue;
    private String aux;
    private boolean selectedDot;
    private boolean selected;
    private ArrayList<Integer> type;

    public GameStructureData(int iDots, int jDots, String password, int[][] matLogic, int gameTurn, boolean shotGun,
            int pointRed, int pointBlue, String aux, boolean selectedDot, boolean selected, ArrayList<Integer> type) {

        this.iDots = iDots;
        this.jDots = jDots;
        this.password = password;
        this.MatLogic = matLogic;
        this.gameTurn = gameTurn;
        this.shotGun = shotGun;
        this.pointRed = pointRed;
        this.pointBlue = pointBlue;
        this.aux = aux;
        this.selectedDot = selectedDot;
        this.selected = selected;
        this.type = type;
    }

    public int getiDots() {
        return iDots;
    }

    public void setiDots(int iDots) {
        this.iDots = iDots;
    }

    public int getjDots() {
        return jDots;
    }

    public void setjDots(int jDots) {
        this.jDots = jDots;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int[][] getMatLogic() {
        return MatLogic;
    }

    public void setMatLogic(int[][] matLogic) {
        MatLogic = matLogic;
    }

    public int getGameTurn() {
        return gameTurn;
    }

    public void setGameTurn(int gameTurn) {
        this.gameTurn = gameTurn;
    }

    public boolean isShotGun() {
        return shotGun;
    }

    public void setShotGun(boolean shotGun) {
        this.shotGun = shotGun;
    }

    public int getPointRed() {
        return pointRed;
    }

    public void setPointRed(int pointRed) {
        this.pointRed = pointRed;
    }

    public int getPointBlue() {
        return pointBlue;
    }

    public void setPointBlue(int pointBlue) {
        this.pointBlue = pointBlue;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public boolean isSelectedDot() {
        return selectedDot;
    }

    public void setSelectedDot(boolean selectedDot) {
        this.selectedDot = selectedDot;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ArrayList<Integer> getType() {
        return type;
    }

    public void setType(ArrayList<Integer> type) {
        this.type = type;
    }

}//end of class 
