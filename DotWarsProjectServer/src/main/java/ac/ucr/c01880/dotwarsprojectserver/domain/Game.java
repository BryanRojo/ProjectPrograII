package ac.ucr.c01880.dotwarsprojectserver.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Game {
	private ArrayList<Silhouette> silhoette; 
	private int tamanio;
	private String password; 
	public Game(int tamaio, String passwrod) {
		this.tamanio=tamaio; 
		this.silhoette= new ArrayList<>(); 
		this.password=passwrod; 
	}//end of class 
	public Game() {
		this.silhoette= new ArrayList<>(); 
	}
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(0, 0, 600, 600);
		
		for (int i = 0; i < this.silhoette.size(); i++) {
			this.silhoette.get(i).draw(g);
		}//end of for 
	}//end of draw(Graphics g)
	
	public void addSilhuetee(int x, int y) {
		this.silhoette.add(new Silhouette(x, y)); 
	}//end of addSiluetee(int x, int y)

	public ArrayList<Silhouette> getSilhoette() {
		return silhoette;
	}

	public void setSilhoette(ArrayList<Silhouette> silhoette) {
		this.silhoette = silhoette;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}//end of class 
