package domain.bots;



public class BotFactory {

	private static BotFactory botFactoryInstance;
	
	 
	public static BotFactory getInstance() {
		
		if(botFactoryInstance == null) {
			botFactoryInstance = new BotFactory();
		}
		
		return botFactoryInstance;
	}
	
	
	public BotStrategy getBotType(String botName) {
		
		
		 if(botName.equals("IntelligentBot")) {
			return new IntelligentBot();
		}
		
		else if(botName.equals("GreedyBot")) 
		{
			return  new GreedyBot();
			
		 }else if(botName.equals("RandomBot")){
			 
			return new RandomBot();
		}
	
		
		else {
			System.out.println("You did not write the code for generating the bot called \" " + botName +"\" in the BotFactory class" );
			return null;
		}
		
	}
}
