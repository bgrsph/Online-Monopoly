package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class BuyersMarketCard extends Card{

	public BuyersMarketCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}