package ac.ucr.c01880.dotwarsprojectserver.bussines;

public class ThreadContolMin extends Thread{
	private boolean suspend; 
	private int timeLife; 
	private Server server;
	
	
	
	
	public ThreadContolMin(Server server) {
		this.server=server;
		this.suspend = false;
		this.timeLife = 0;
	}//end of class 

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				
				
				this.server.acceptClient();
				
				if (this.timeLife==600000) {
					
					

					wait();
				}//end of if 
				
				
				
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
