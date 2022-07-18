package ac.ucr.c01880.dotwarsprojectserver.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import ac.ucr.c01880.dotwarsprojectserver.domain.SingletonGameServer;



public class JPPitch extends JPanel {
	
	public JPPitch() {
		setBackground(Color.WHITE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400,300));
		
		this.setFocusable(true);
		this.requestFocus();
	}//end of constructor 
	public void paintComponent(Graphics g) {
		SingletonGameServer.getIntance().getGame().draw(g);
	}
}//end of class 
