package domain;

import ui.MonopolyGameFrame;

public class Application {
	
	

	public static void main(String[] args) {
		//The runnable game
		
		Thread monopolyGameApplication = new Thread(new Runnable() {
			
			public void run() {
				
			
				//StartGameFrame startFrame = new StartGameFrame();
					MonopolyGameFrame mf = new MonopolyGameFrame();
				
		

			}
		});
		
		
		monopolyGameApplication.start(); 

	}

}
