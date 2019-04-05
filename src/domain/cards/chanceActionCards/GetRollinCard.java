package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class GetRollinCard extends Card{

	public GetRollinCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}