package ac.ucr.c01880.dotwarsprojectserver.bussines;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ac.ucr.c01880.dotwarsprojectserver.domain.SingletonGameServer;




public class Server {
	private ServerSocket server;
	private Socket client; 
	private DataInputStream read;
	private DataOutputStream write; 
	private Socket[] clients;
	boolean close;

	private String message;
	private Logic logic; 
	private int posUser; 
	private ArrayList<Socket> clientsGod;
	public Server( Logic logic) {
		this.message="";
		
		clients = new Socket[2];
		this.clientsGod= new ArrayList<>(); 
		this.createServer(5000);
		this.close = false;
		
	}//end of class
	
	public void createServer(int port) {
		
		try {
			this.server = new ServerSocket(port);
			System.out.println("Servidor iniciado en el puerto 5000");
			
		
		}catch (java.net.SocketTimeoutException e) {
			//JOptionPane.showMessageDialog(window, "deay mae esta vara no se como funca ");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}//end of class
public void acceptClient() {
		
		try {
			this.client= new Socket(); 
			client = server.accept();
			
			
			
//					if (SingletonGameServer.getIntance().getGame().getSilhoette().size()==1) {
//						System.out.println(SingletonGameServer.getIntance().getGame().getSilhoette().size());
//						SingletonGameServer.getIntance().getGame().addSilhuetee(5, 0);
//					}else {
//						System.out.println("entre aqui");
//						SingletonGameServer.getIntance().getGame().addSilhuetee(0, 0);
//					}
				
				this.clientsGod.add(client); 
				ThreadControlClient ThreadClient= new ThreadControlClient(client, logic,  this.clientsGod); 
				ThreadClient.start();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}//end of acceptClient

}
