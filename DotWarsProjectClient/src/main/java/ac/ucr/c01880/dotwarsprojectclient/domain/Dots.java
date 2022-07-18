package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import ac.ucr.c01880.dotwarsprojectclient.utility.Route;
import java.io.File;

public class Dots {

    private int x;
    private int y;
    private int lifePoints;
    private int attackPoints;
    private int attackRange;
    private int walkingSteps;
    private BufferedImage image;
    private int type;
    private Bullet bullet;

    public Dots(int x, int y, int type) {

        this.attackPoints = 1;
        this.lifePoints = 3;
        this.attackRange = 3;
        this.walkingSteps = 1;
        this.x = x;
        this.y = y;
        this.type = type;
        try {

            if (this.type == 1) {

                File file = new File(Route.ROUTEDOTSBLUE);
                this.image = ImageIO.read(file);
            } else {

                File file = new File(Route.ROUTEDOTSRED);
                this.image = ImageIO.read(file);
            }

        } catch (IOException ex) {
            System.err.println("No se pudo cargar la imagen del Dot");
        } // try-catch
        this.bullet = new Bullet(this);
    }//end of costructor 

    public void draw(Graphics g) {
        this.bullet.paint(g);
        g.drawImage(image, x * 20, y * 20, null);
    }//end of dibujar(Graphics g)

    public void movDotRight() {

        this.x += this.walkingSteps;
        this.bullet.setX((this.bullet.getX() + this.walkingSteps));
    }

    public void movDotUp() {
        this.y -= this.walkingSteps;
        this.bullet.setY((this.bullet.getY() - this.walkingSteps));

    }

    public void movDotDown() {
        this.y += this.walkingSteps;
        this.bullet.setY((this.bullet.getY() + this.walkingSteps));

    }

    public void movDotLeft() {
        this.x -= this.walkingSteps;
        this.bullet.setX((this.bullet.getX() - this.walkingSteps));

    }

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

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getWalkingSteps() {
        return walkingSteps;
    }

    public void setWalkingSteps(int walkingSteps) {
        this.walkingSteps = walkingSteps;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

}//end of class 
