package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class MardiGrasCard extends Card{

	public MardiGrasCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}