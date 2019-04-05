package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

/*
 * There are 2 types of this card. Overload the constructor!
 * Or create another card class for the second type
 */

public class ChangingLanesCard extends Card{

	public ChangingLanesCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}