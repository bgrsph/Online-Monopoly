package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class SeeYouInCourtCard extends Card{

	public SeeYouInCourtCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
		String s = null;
		//MonopolyGameController.getInstance().Facade.getInstance();
		//s =Facade.takesStringFromPlayerViaTextBox();
		
		useCard(s);
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
	
	
	public void useCard(String s) {
		for(Player p: MonopolyGameController.getPlayers()) {
			if(p.getName().equals(s)){
				p.decreaseMoney(250);
			}
		}
	}
	
	
}