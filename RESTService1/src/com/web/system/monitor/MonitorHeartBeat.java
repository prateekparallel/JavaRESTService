/****
 * This is a health check thread example. You can add more threads like this 
 * in your application as per your requirement. This class will spawns
 *  a thread at the very beginning, when this web service application will start loading.
 *  This thread will be instantiated from startup servlet. 
 */
package com.web.system.monitor;

public final class MonitorHeartBeat {
	boolean keepProcessing_ = true;
	public MonitorHeartBeat() {
		
			try {
				Thread t = new Thread(new HealthCheck());
				t.start();
			}
			catch (Exception e) {
			}	
		}					

	private class HealthCheck implements Runnable  {
		
		public HealthCheck() {	
		}		
		
		@SuppressWarnings("unchecked")
		public void run() {				
			do {
				//your health check codes 
				//For example you make some web calls from this application
				//to a remote server and get some information from that server
				//now you can put a web call every after 5 minutes from here to check whether remote server
				//is up and running or not if not you can send mail to concern team that the remove server is down
				try {
						System.out.println("I will add my health check code here");
						Thread.sleep(1000);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}while (keepProcessing_);			 
		}
	}
	
	private final synchronized void stopProcessing() {		
	    keepProcessing_ = false;
    }
	
	public void destroy() {
		//This method need to be called from servlet 
		stopProcessing();	 	
    } 
}
