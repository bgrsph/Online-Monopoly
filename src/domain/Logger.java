package domain;


import ui.Facade;

public class Logger  {
	
	private static Logger loggerInstance;
	
	
	
	
	public static Logger getInstance() {
		
		if(loggerInstance == null) {
			loggerInstance = new Logger();
		}
		
		return loggerInstance;
	}
	
	
	
	public void clearLog() {
		Facade.getInstance();
		Facade.clearLog();
	}
 




	public void notifyAll(String notification) {
		 
		Facade.getInstance();
		Facade.notifyPlayers(notification);
		
		
	}



	public void notifyLocal(String string) {
		Facade.getInstance();
		Facade.notifyPlayers(string);
		
	}
	
	

}
