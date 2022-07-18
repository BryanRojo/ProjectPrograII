package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ac.ucr.c01880.dotwarsprojectclient.bussiness.Logic;

public class Game {

    private BackGround backGround;
    private boolean selectedDot;
    private int iDots, jDots;
    private Board board;
    private ArrayList<Stats> stats;
    private SaveGame saveGame;
    private boolean selected;
    private Logic logic;
    private String password;
    private DotsFlag dotsFlag;
    private int gameTurn;
    private boolean shotGun;
    private int pointRed, pointBlue;
    private String aux;
    private int mat[][];
    private NeverSurrender surrender;

    public Game(int x, int y, String password) {
        this.gameTurn = 102;
        this.password = password;
        this.logic = new Logic();
        this.board = new Board(x, y);
        this.saveGame = new SaveGame(740, 10);
        this.dotsFlag = new DotsFlag(740, 50);
        this.backGround = new BackGround();
        this.stats = new ArrayList<>();
        this.createStats();
        this.selected = false;
        this.iDots = -1;
        this.jDots = -1;
        this.pointBlue = 0;
        this.pointRed = 0;
        this.aux = "Puntos: " + this.pointBlue;
        this.surrender = new NeverSurrender(740, 105);
    }//end of Game 

    public Game(boolean selectedDot, int iDots, int jDots, boolean selected, String password,
            int gameTurn, boolean shotGun, int pointRed, int pointBlue, String aux, int mat[][], ArrayList<Integer> dats) {
        this.mat = mat;
        this.logic = new Logic();
        this.board = new Board(mat.length, mat.length, this.buildBoard(mat));
        this.createDots(dats);
        this.saveGame = new SaveGame(740, 10);
        this.dotsFlag = new DotsFlag(740, 50);
        this.backGround = new BackGround();
        this.stats = new ArrayList<>();
        this.createStats();

        this.selectedDot = selectedDot;
        this.iDots = iDots;
        this.jDots = jDots;
        this.selected = selected;
        this.password = password;
        this.gameTurn = gameTurn;
        this.shotGun = shotGun;
        this.pointRed = pointRed;
        this.pointBlue = pointBlue;
        this.aux = aux;
        this.surrender = new NeverSurrender(740, 105);
    }

    public void draw(Graphics g) {

        this.backGround.draw(g);
        this.dotsFlag.paint(g);
        this.saveGame.paint(g);
        this.surrender.paint(g);
        for (int i = 0; i < this.stats.size(); i++) {
            this.stats.get(i).paint(g);
        }
        this.board.draw(g);
        g.drawString(aux, 740, 100);
    }

    public void impactDot(int mouseX, int mouseY) {
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares().length; j++) {

                if (this.emptySquare(i, j)) {
                    if (this.logic.impactDot(this.board.getSquares()[i][j].getDot(), mouseX, mouseY)) {
                        this.setiDots(i);
                        this.setjDots(j);
                        this.selectedTrue();
                        System.out.println(i + "  " + j);
                        System.out.println("holiwi");
                        return;
                    } else {
                        this.selectedFalse();
                    }
                }

            }
        }

    }//end of impactDot(int x, int y )

    public void movDotRight(int iDots, int jDots) {
        if (!this.shotGun) {
            if (!this.checkCoordinates(iDots, jDots)) {
                if (this.emptySquare(iDots, jDots) && (iDots + this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()) < this.board.getSquares().length) {
                    if (this.isturn(iDots, jDots)) {

                        this.board.getSquares()[iDots][jDots].getDot().movDotRight();
//					this.board.getSquares()[iDots][jDots].getDot().setX(
//							this.board.getSquares()[this.iDots][this.jDots].getDot().getX()+1);
//					
                        this.board.getSquares()[iDots + this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()][this.jDots].setDot(
                                this.board.getSquares()[iDots][jDots].getDot()
                        );
                        this.board.getSquares()[iDots][jDots].setDot(null);
                        this.testMov();
                        this.restartCoordinates();
                        this.changeMov();
                    }

                }
            }
        }

    }//end of movDotRight()

    public void movDotUp(int iDots, int jDots) {
        if (!this.shotGun) {
            if (!this.checkCoordinates(iDots, jDots)) {
                if (this.emptySquare(iDots, jDots) && (jDots - this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()) >= 0) {
                    if (this.isturn(iDots, jDots)) {

                        this.board.getSquares()[iDots][jDots].getDot().movDotUp();
//						this.board.getSquares()[this.iDots][this.jDots].getDot().setY(
//								this.board.getSquares()[this.iDots][this.jDots].getDot().getY()-1);
//						
                        this.board.getSquares()[iDots][jDots - this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()].setDot(
                                this.board.getSquares()[iDots][jDots].getDot()
                        );
                        this.board.getSquares()[iDots][jDots].setDot(null);
                        this.testMov();
                        this.restartCoordinates();
                        this.changeMov();
                    }

                }
            }
        }

    }

    public void movDotDown(int iDots, int jDots) {
        if (!this.shotGun) {
            if (!this.checkCoordinates(iDots, jDots)) {
                if (this.emptySquare(iDots, jDots) && (jDots + this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()) < this.board.getSquares().length) {
                    if (this.isturn(iDots, jDots)) {
                        this.board.getSquares()[iDots][jDots].getDot().movDotDown();
//						this.board.getSquares()[this.iDots][this.jDots].getDot().setY(
//								this.board.getSquares()[this.iDots][this.jDots].getDot().getY()+1);
//						
                        this.board.getSquares()[iDots][jDots + this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()].setDot(
                                this.board.getSquares()[iDots][jDots].getDot()
                        );
                        this.board.getSquares()[iDots][jDots].setDot(null);
                        this.testMov();
                        this.restartCoordinates();
                        this.changeMov();
                    }

                }

            }
        }

    }

    public void movDotLeft(int iDots, int jDots) {
        if (!this.shotGun) {
            if (!this.checkCoordinates(iDots, jDots)) {
                if (this.emptySquare(iDots, jDots) && (iDots - this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()) >= 0) {
                    System.out.println(iDots + "haaaaaaaaaa" + this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps() + "resta: " + (iDots - this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()));
                    if (this.isturn(iDots, jDots)) {
                        this.board.getSquares()[iDots][jDots].getDot().movDotLeft();
//						this.board.getSquares()[this.iDots][this.jDots].getDot().setX(
//								this.board.getSquares()[this.iDots][this.jDots].getDot().getX()-1);
//						
                        this.board.getSquares()[iDots - this.board.getSquares()[iDots][jDots].getDot().getWalkingSteps()][this.jDots].setDot(
                                this.board.getSquares()[iDots][jDots].getDot()
                        );
                        this.board.getSquares()[iDots][jDots].setDot(null);
                        this.testMov();
                        this.restartCoordinates();
                        this.changeMov();
                    }

                }
            }
        }

    }
    //inicio de los metodos complemantarios privados 

    private void restartCoordinates() {
        this.iDots = -1;
        this.jDots = -1;
        this.selected = false;
    }//end of restartCoordinates()

    private boolean checkCoordinates(int i, int j) {
        return i == -1 && j == -1;
    }//end of checkCoordinates(int i, int j)

    private void changeMov() {
        this.gameTurn = this.gameTurn - 1;
        System.out.println(this.gameTurn);
    }

    public int[][] testMov() {
        System.out.println("---------------------------------");
        int[][] matLogic = new int[this.board.getSquares().length][this.board.getSquares().length];
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares().length; j++) {
                if (this.board.getSquares()[j][i].emptySquare()) {
                    if (this.board.getSquares()[j][i].getDot().getType() == 1) {
                        matLogic[j][i] = 1;
                        System.out.print("1 ");
                    } else {
                        matLogic[j][i] = 2;
                        System.out.print("2 ");
                    }

                } else {
                    System.out.print("0 ");
                    matLogic[j][i] = 0;

                }
            }
            System.out.println(" ");
        }
        return matLogic;
    }//end of testMov()

    private void createStats() {

        this.stats.add(new Attack(700, 350));
        this.stats.add(new Life(700, 400));
        this.stats.add(new Move(700, 450));
        this.stats.add(new Range(700, 500));
        this.stats.add(new Strength(700, 550));

    }//end of createStats()

    public Dots returnDot() {
        if (!this.checkCoordinates(iDots, jDots)) {
            if (this.emptySquare(iDots, jDots)) {
                return this.board.getSquares()[iDots][jDots].getDot();
            }
        }
        return null;
    }//end of returnDot()

    public void actionStats(int x, int y) {
        for (int i = 1; i < this.stats.size(); i++) {
            if (this.logic.impactStats(this.stats.get(i), x, y)) {
                if (!this.checkCoordinates(iDots, jDots)) {
                    if (this.isturn(iDots, jDots)) {
                        if (this.turn() == 1) {
                            if (this.stats.get(i).getCost() <= this.pointBlue) {
                                this.stats.get(i).action(this.board.getSquares()[iDots][jDots].getDot());
                                this.pointBlue = this.pointBlue - this.stats.get(i).getCost();
                                this.aux = "Puntos: " + this.pointBlue;
                            }
                        } else {
                            if (this.stats.get(i).getCost() <= this.pointRed) {
                                this.stats.get(i).action(this.board.getSquares()[iDots][jDots].getDot());
                                this.pointRed = this.pointRed - this.stats.get(i).getCost();
                                this.aux = "Puntos: " + this.pointRed;
                            }
                        }

                    }
                }

            }

        }//end of for i 
        if (this.logic.impactStats(this.stats.get(0), x, y)) {
            if (!this.checkCoordinates(iDots, jDots)) {
                if (this.isturn(iDots, jDots)) {

                    this.stats.get(0).action(this.board.getSquares()[iDots][jDots].getDot());
                }
            }

        }
    }

    public void shotGun(int x, int y) {
        int type = 0;
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares().length; j++) {
                if (this.board.getSquares()[i][j].emptySquare()) {
                    if (logic.impactDot(this.board.getSquares()[i][j].getDot(), x, y)) {
                        if (this.board.getSquares()[i][j].getDot().getType() != this.board.getSquares()[iDots][jDots].getDot().getType()) {
                            int absRange = Math.abs(this.board.getSquares()[i][j].getDot().getY() - this.board.getSquares()[iDots][jDots].getDot().getY());
                            if (absRange <= this.board.getSquares()[iDots][jDots].getDot().getAttackRange()) {
                                System.out.println(this.board.getSquares()[i][j].getDot().getLifePoints() + "<-puntos de vida" + this.board.getSquares()[iDots][jDots].getDot().getAttackPoints() + "<-puntos de da;o");
                                this.board.getSquares()[i][j].getDot().setLifePoints(this.board.getSquares()[i][j].getDot().getLifePoints() - this.board.getSquares()[iDots][jDots].getDot().getAttackPoints());
                                this.shotGun = false;
                                System.out.println(this.board.getSquares()[i][j].getDot().getLifePoints() + "<-puntos de vida" + this.board.getSquares()[iDots][jDots].getDot().getAttackPoints() + "<-puntos de da;o");
                                this.gameTurn--;
                                if (this.board.getSquares()[i][j].getDot().getLifePoints() == 0) {
                                    type = this.board.getSquares()[i][j].getDot().getType();
                                    this.board.getSquares()[i][j].setDot(null);
                                }
                                if (this.lost(type)) {
                                    if (SingletonControllerGame.getIntance().getGame().lost(1)) {
                                        //SingletonControllerGame.getIntance().getControler().getWindowS().dispose();
                                        JOptionPane.showMessageDialog(null, "Ganan las rojas");
                                    }
                                    if (SingletonControllerGame.getIntance().getGame().lost(2)) {
                                        //SingletonControllerGame.getIntance().getControler().getWindowS().dispose();
                                        JOptionPane.showMessageDialog(null, "Ganan las azules");
                                    }

                                }
                            }
                        }

                    }
                }

            }
        }

    }//end of shotGun(int x, int y )    

    public void comprobatePointsRed() {
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares()[i].length; j++) {
                if (this.board.getSquares()[i][j].fullSquare()) {
                    if (this.board.getSquares()[i][j].getDot().getType() == 2) {
                        this.pointRed++;
                    }
                }
            }
        }

    }//end of  comprobatePointsRed()

    public void comprobatePointsBlue() {
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares()[i].length; j++) {
                if (this.board.getSquares()[i][j].fullSquare()) {
                    if (this.board.getSquares()[i][j].getDot().getType() == 1) {
                        this.pointBlue++;
                    }
                }
            }
        }

    }//end of comprobatePointsBlue()

    private boolean isturn(int i, int j) {
        System.out.println((int) this.gameTurn / 100 + " " + this.board.getSquares()[i][j].getDot().getType());
        return (int) this.gameTurn / 100 == this.board.getSquares()[i][j].getDot().getType();
    }

    private Square[][] buildBoard(int mat[][]) {
        Square squares[][] = new Square[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.println(mat[j][i]);
                if (mat[j][i] == 1) {

                    squares[j][i] = new Square(j, i);
                    squares[j][i].setDot(new Dots(j, i, 1));
                    System.out.println("entreaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                }
                if (mat[j][i] == 2) {
                    squares[j][i] = new Square(j, i);
                    squares[j][i].setDot(new Dots(j, i, 2));
                    System.out.println("entrebbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                }
                if (mat[j][i] == 0) {
                    squares[j][i] = new Square(j, i);
                }
            }
        }
        return squares;
    }

    private void createDots(ArrayList<Integer> dats) {
        System.out.println("aaaaaaaaaaaaa+ /n");
        for (int i = 0; i < dats.size(); i++) {
            System.out.println(dats.get(i));
        }
        int aux = (dats.size() / 2);
        System.out.println((dats.size() / 2));
        int auxJ = 0;
        for (int i = 0; i < aux; i++) {
            System.out.println(i);
            System.out.println(auxJ + "   " + (auxJ + 1));
            this.getBoard().getSquares()[dats.get(auxJ + 1)][dats.get(auxJ)].setDotsMana(new DotsMana(dats.get(auxJ + 1), dats.get(auxJ)));

            auxJ += 2;
        }//end of for 

    }//end of createDots(String type) 

    public ArrayList<Integer> createDotsOcupation() {
        ArrayList<Integer> dats = new ArrayList<>();
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares().length; j++) {
                if (this.board.getSquares()[j][i].manaBox()) {
                    dats.add(i);
                    dats.add(j);
                }

            }//end of for 

        }//end of for 
        return dats;
    }//end of createDots(String type) 

    public boolean lost(int type) {
        int cont = 0;
        for (int i = 0; i < this.board.getSquares().length; i++) {
            for (int j = 0; j < this.board.getSquares().length; j++) {
                if (this.board.getSquares()[i][j].emptySquare()) {
                    if (this.board.getSquares()[i][j].getDot().getType() == type) {
                        cont++;
                    }
                }

            }
        }
        if (cont == 0) {
            return true;
        } else {
            return false;
        }
    }//end of class 

    private int turn() {
        return (int) this.gameTurn / 100;
    }

    public void selectedTrue() {
        this.selected = true;
    }

    public void selectedFalse() {
        this.selected = false;
    }
    //fin de los metodos complemantarios privados 

    public boolean emptySquare(int i, int j) {
        return this.board.getSquares()[i][j].emptySquare();
    }

    public boolean isSelectedDot() {
        return selectedDot;
    }

    public void setSelectedDot(boolean selectedDot) {
        this.selectedDot = selectedDot;
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SaveGame getSaveGame() {
        return saveGame;
    }

    public void setSaveGame(SaveGame saveGame) {
        this.saveGame = saveGame;
    }

    public int getGameTurn() {
        return gameTurn;
    }

    public void setGameTurn(int gameTurn) {
        this.gameTurn = gameTurn;
    }

    public DotsFlag getDotsFlag() {
        return dotsFlag;
    }

    public void setDotsFlag(DotsFlag dotsFlag) {
        this.dotsFlag = dotsFlag;
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

    public NeverSurrender getSurrender() {
        return surrender;
    }

    public void setSurrender(NeverSurrender surrender) {
        this.surrender = surrender;
    }

}//end of Game 
