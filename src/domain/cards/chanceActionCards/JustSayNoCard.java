package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class JustSayNoCard extends Card{

	public JustSayNoCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}