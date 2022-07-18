package ac.ucr.c01880.dotwarsprojectclient.bussiness;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import ac.ucr.c01880.dotwarsprojectclient.domain.Game;
import ac.ucr.c01880.dotwarsprojectclient.domain.SingletonControllerGame;
import ac.ucr.c01880.dotwarsprojectclient.domain.ThreadGameplay;
import ac.ucr.c01880.dotwarsprojectclient.domain.ThreadStats;
import ac.ucr.c01880.dotwarsprojectclient.presentation.JPPitch;
import ac.ucr.c01880.dotwarsprojectclient.utility.Route;





public class Client {
	private Socket client;
	private DataOutputStream write;
	private DataInputStream read; 
	private String name;

	private Logic logic;
	private String message;
	
	public Client(Logic logic, String name) {
		this.message="";
		this.name= name; 
		this.createClient(5000);
		this.logic=logic;
		this.SendMessage(this.name);
		
	}//end of constructor 
	
	

	public void createClient(int port) {
		try {
			this.client = new Socket("localhost", port);
			
			System.out.println("se creo el cliente");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of craeteCliente
	public void SendMessage(String message) {
		try {
			
			
				this.write = new DataOutputStream(client.getOutputStream());
				
				
				write.writeUTF(message);
				System.out.println(message);
			
				
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}//end of SendMessage
	
	public void MessageServer() {

		try {
			
			
				this.read = new DataInputStream(client.getInputStream());
				this.message=read.readUTF();
				String[] data;
				data= this.message.split(":");
				System.out.println(message);
				System.out.println(data[0]);
				System.out.println(Route.CREATEGAMESERIUS);
				System.out.println(data[0].equals(Route.CREATEGAMESERIUS));
				if (data[0].equals(Route.CREATEGAMESERIUS)) {
					SingletonControllerGame.getIntance().setGame(new Game(Integer.parseInt(data[1]),Integer.parseInt(data[1]), data[2]));		
				}else if (data[1].equals(Route.MOVUP)) {
					SingletonControllerGame.getIntance().movDotUp(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
				}else if (data[1].equals(Route.MOVDOWN)) {
					SingletonControllerGame.getIntance().movDotDown(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
				}else if (data[1].equals(Route.MOVRIGTH)) {
					SingletonControllerGame.getIntance().movDotRight(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
				}else if (data[1].equals(Route.MOVLEFT)) {
					SingletonControllerGame.getIntance().movDotLeft(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
				}
				
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void CloseClient() {
		try {
			
			
				write.close();
			
			
				read.close();
			
			
				this.client.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end of CloseClient

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


}
