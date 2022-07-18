package ac.ucr.c01880.dotwarsprojectclient.presentation;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;

import ac.ucr.c01880.dotwarsprojectclient.domain.Game;
import ac.ucr.c01880.dotwarsprojectclient.domain.SingletonControllerGame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;



public class JPPitch extends JPanel implements MouseListener, KeyListener{
	private JLabel jlblAttack;
	private JLabel jlblLife;
	private JLabel jlblMove;
	private JLabel jlblRange;
	private JLabel jlblStrength;
	
	
	public JPPitch(int x, int y, String password) {
		setBackground(Color.WHITE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		SingletonControllerGame.getIntance().setGame(new Game(x, y, password));
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
		this.addMouseListener(this);
		add(getJlblAttack());
		add(getJlblLife());
		add(getJlblMove());
		add(getJlblRange());
		add(getJlblStrength());
	}//end of constructor 
	public JPPitch() {
		setBackground(Color.WHITE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
		this.addMouseListener(this);
		add(getJlblAttack());
		add(getJlblLife());
		add(getJlblMove());
		add(getJlblRange());
		add(getJlblStrength());
	}//end of constructor 
	
	protected void paintComponent(Graphics g) {
		SingletonControllerGame.getIntance().getGame().draw(g);
    	this.repaint();
		
	}//end of  paintComponent
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_D) {
		
			SingletonControllerGame.getIntance().movSendRight();
			
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			SingletonControllerGame.getIntance().movSendLeft();
		
			
		}
		if(e.getKeyCode()==KeyEvent.VK_W) {
			SingletonControllerGame.getIntance().movSendUp();
			
			
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			SingletonControllerGame.getIntance().movSendDown();
			
			
		}
		
	}//end of keyPressed(KeyEvent e)

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (SingletonControllerGame.getIntance().getGame().isShotGun()) {
			SingletonControllerGame.getIntance().getGame().shotGun(e.getX(), e.getY());
		}else {
			//SingletonControllerGame.getIntance().impacSurrender(e.getX(), e.getY());
			SingletonControllerGame.getIntance().getGame().actionStats(e.getX(), e.getY());
			SingletonControllerGame.getIntance().impactDot(e.getX(), e.getY());
//			try {
//				//SingletonControllerGame.getIntance().saveGame(e.getX(), e.getY());
//			} catch (ClassNotFoundException | IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JLabel getJlblAttack() {
		if (jlblAttack == null) {
			jlblAttack = new JLabel("Attack: ");
			jlblAttack.setForeground(Color.WHITE);
			jlblAttack.setBackground(Color.BLACK);
			jlblAttack.setBounds(744, 370, 114, 14);
		}
		return jlblAttack;
	}
	public JLabel getJlblLife() {
		if (jlblLife == null) {
			jlblLife = new JLabel("Life:");
			jlblLife.setForeground(Color.RED);
			jlblLife.setBackground(Color.BLACK);
			jlblLife.setBounds(744, 430, 114, 14);
		}
		return jlblLife;
	}
	public JLabel getJlblMove() {
		if (jlblMove == null) {
			jlblMove = new JLabel("Mov: ");
			jlblMove.setForeground(Color.WHITE);
			jlblMove.setBackground(Color.BLACK);
			jlblMove.setBounds(744, 480, 114, 14);
		}
		return jlblMove;
	}
	public JLabel getJlblRange() {
		if (jlblRange == null) {
			jlblRange = new JLabel("Rango: ");
			jlblRange.setForeground(Color.WHITE);
			jlblRange.setBackground(Color.BLACK);
			jlblRange.setBounds(744, 530, 88, 14);
		}
		return jlblRange;
	}
	public JLabel getJlblStrength() {
		if (jlblStrength == null) {
			jlblStrength = new JLabel("Fuerza: ");
			jlblStrength.setBackground(Color.BLACK);
			jlblStrength.setForeground(Color.WHITE);
			jlblStrength.setBounds(744, 580, 88, 14);
		}
		return jlblStrength;
	}
}//end of class 
