package ac.ucr.c01880.dotwarsprojectserver.bussines;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ac.ucr.c01880.dotwarsprojectserver.domain.Game;
import ac.ucr.c01880.dotwarsprojectserver.domain.SingletonGameServer;
import ac.ucr.c01880.dotwarsprojectserver.utility.Route;





public class ThreadControlClient extends Thread{
	
	private boolean suspend; 
	private Server server;
	private Socket client; 
	private String getMessage; 
	private String sendMessage; 
	private Logic logic;

	private ArrayList<Socket> clients; 
	public ThreadControlClient(Socket client2, Logic logic,
			ArrayList<Socket> clients) {
		this.client=client2; 
		this.suspend = false;
		this.getMessage=""; 
		this.sendMessage=""; 
		this.logic=logic; 
		this.clients=clients; 
	}//end of class 

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				
				DataInputStream read = new DataInputStream(client.getInputStream());
				this.getMessage = read.readUTF();
				
				String[] data;
				System.out.println(getMessage);
				data= this.getMessage.split(":");
				System.out.println(data[0]+" "+data[1]);
				if (data[1].equals(Route.CREATEGAME)) {
					int aux=JOptionPane.showConfirmDialog(null, "Permitir crear un juego de: "+data[2], "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					System.out.println(aux);
					if (aux==0) {
						
						SingletonGameServer.getIntance().getGame().setPassword( data[3]);
						SingletonGameServer.getIntance().getGame().setTamanio(Integer.parseInt(data[2]));
						SingletonGameServer.getIntance().getGame().addSilhuetee(0, 0);
						System.out.println("hello");
					}
					
				}else
				if (data[1].equals(Route.CONECTGAME)) {
					if (SingletonGameServer.getIntance().getGame().getPassword().equals(data[2])) {
						SingletonGameServer.getIntance().getGame().addSilhuetee(5, 0);
					}
					if (SingletonGameServer.getIntance().getGame().getSilhoette().size()==2 ) {
						for (int i = 0; i < this.clients.size(); i++) {
							DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
							
							write.writeUTF(Route.CREATEGAMESERIUS+":"+SingletonGameServer.getIntance().getGame().getTamanio()+":"+SingletonGameServer.getIntance().getGame().getPassword());
						}
					}//end of SingletonGameServer.getIntance().getGame().getSilhoette().size()==2
				}else if (data[1].equals(Route.MOVDOWN)) {
					for (int i = 0; i < this.clients.size(); i++) {
						DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
						
						write.writeUTF(getMessage);
					}
				}else if (data[1].equals(Route.MOVLEFT)) {
					for (int i = 0; i < this.clients.size(); i++) {
						DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
						
						write.writeUTF(getMessage);
					}
				}else if (data[1].equals(Route.MOVUP)) {
					for (int i = 0; i < this.clients.size(); i++) {
						DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
						
						write.writeUTF(getMessage);
					}
				}else if (data[1].equals(Route.MOVRIGTH)) {
					for (int i = 0; i < this.clients.size(); i++) {
						DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
						
						write.writeUTF(getMessage);
					}
				}else{
					for (int i = 0; i < this.clients.size(); i++) {
						DataOutputStream write = new DataOutputStream(this.clients.get(i).getOutputStream());
						
						write.writeUTF(sendMessage+":"+data[0]+":"+data[1]);
					}
				}

				
				
				
				
				
				
					
					
				
				
				
				
				
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


			


}
