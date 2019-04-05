package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class ForwardThinkerCard extends Card{

	public ForwardThinkerCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}