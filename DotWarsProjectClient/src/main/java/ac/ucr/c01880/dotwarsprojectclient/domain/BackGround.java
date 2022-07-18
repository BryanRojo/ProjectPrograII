package ac.ucr.c01880.dotwarsprojectclient.domain;

import java.awt.Graphics;

import java.io.Serializable;

public class BackGround {

    public BackGround() {

    }

    public void draw(Graphics g) {

        g.fillRect(0, 0, 2000, 2000);
    }

}//end of BackGround
