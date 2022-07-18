package ac.ucr.c01880.dotwarsprojectclient.bussiness;

public class ThreadControlClient extends Thread{
private boolean suspend;
	
	private Client client; 
	
	public ThreadControlClient (Client client) {
		this.suspend=false;
		
		this.client = client;
	}//end of class
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				
					synchronized (this) {
						if (suspend) {
							wait();
						}
					}
				
				
				
				this.client.MessageServer();
				
				
			
				
				
					
				
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
