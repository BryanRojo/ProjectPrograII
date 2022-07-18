package ac.ucr.c01880.dotwarsprojectclient.domain;

import javax.swing.JOptionPane;

import ac.ucr.c01880.dotwarsprojectclient.presentation.JPPitch;

//import GUI.JPPitch;

public class ThreadStats extends Thread{
	
	private boolean suspend; 
	private int timeLife; 
	private JPPitch jpPitch; 
	private Dots dot; 
	
	
	
	public ThreadStats(JPPitch jpPitch) {
		this.jpPitch=jpPitch; 
		this.suspend = false;
		this.timeLife = 0;
	}//end of class 

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				
				
				if (SingletonControllerGame.getIntance().getGame().isSelected()) {
					if (SingletonControllerGame.getIntance().getGame().returnDot()!=null) {
						this.dot=SingletonControllerGame.getIntance().getGame().returnDot(); 
						this.jpPitch.getJlblLife().setText("Vida: "+this.dot.getLifePoints());
						this.jpPitch.getJlblMove().setText("Mov: "+this.dot.getWalkingSteps()); 
						this.jpPitch.getJlblRange().setText("Rango: "+this.dot.getAttackRange()); 
						this.jpPitch.getJlblStrength().setText("Fuerza: "+this.dot.getAttackPoints());
					}
				}else {
					this.jpPitch.getJlblLife().setText("Vida: ");
					this.jpPitch.getJlblMove().setText("Mov: "); 
					this.jpPitch.getJlblRange().setText("Rango: "); 
					this.jpPitch.getJlblStrength().setText("Fuerza: ");
					
				}
				
				
				
				
				this.timeLife++; 
				

				synchronized (this) {
					if (suspend) {
						wait();
					}
				}
			
				
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}//end of run
		
		public synchronized void suspendThread() {
			this.suspend=true;
		}
		public synchronized void resumeThread() {
			this.suspend=false;
			notify();
		}


}//end of class 
