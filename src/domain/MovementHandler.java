package domain;

public class MovementHandler {
	
	
	private static MovementHandler instance;
	
	public static MovementHandler getInstance() {
	
		if(instance == null) {
			
			instance = new MovementHandler();
			return instance;
		} else {
			
			return instance;
		}
	}
	
	
	
	public int handleNextSquare(int pos, int direction) {
		int result = pos;
		 
		if(pos == 0 && direction == -1)  {
			
			result = 39;

		}
		
		else if(pos == 39 && direction == 1) {
			result = 0;
		}
		
		
		else if(pos == 40 && direction == -1) {
			result = 63;
		}
		
		else if(pos == 63 && direction == 1) {
			result = 40;
		}
		
		
		else if(pos == 64 && direction == -1) {
			result = 119;
		}
		
		else if(pos == 119 && direction == 1) {
			result = 64;
		}
		else {
			//result += direction;
		}
		
		return result + direction ;
	}
	
	
	public int handleRailRoadSquare(int pos, int direction) 
	{
		int result = pos;
		
		if(pos == 5) {
			result = 71;
		}
		
		else if(pos == 15) {
			result = 49;
		}
		
		else if(pos == 25) {
			result = 99;
		}
		
		else if(pos == 35) {
			result = 61;
		}
		
		
		else if(pos == 49) {
			result = 15;
		}
		
		else if(pos == 61) {
			result = 35;
		}
		
		else if(pos == 71) {
			result = 5;
		}
		
		else if(pos == 99) {
			result = 25;
		}

		return result + direction;
	}
	
	
	
	
	
	
	
	
	
	
	

}
