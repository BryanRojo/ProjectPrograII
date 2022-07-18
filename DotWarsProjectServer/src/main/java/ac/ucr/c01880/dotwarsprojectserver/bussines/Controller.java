package ac.ucr.c01880.dotwarsprojectserver.bussines;

import javax.swing.JFrame;

import ac.ucr.c01880.dotwarsprojectserver.presentation.JPPitch;



public class Controller {
	private JFrame windowS;
	private JPPitch jpPitch; 
	private Server server; 
	private ThreadContolMin threadServer; 
	private Logic logic; 
	
	public Controller() {
		this.logic=new Logic(); 
		this.server=new Server(this.logic); 
		windowS=new JFrame();
		this.jpPitch= new JPPitch();
		windowS.getContentPane().add(this.jpPitch);
		windowS.pack();
		windowS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowS.setVisible(true);
		this.threadServer= new ThreadContolMin(this.server); 
		this.threadServer.start();
		
	}//end of class
	
	
}//end of class
