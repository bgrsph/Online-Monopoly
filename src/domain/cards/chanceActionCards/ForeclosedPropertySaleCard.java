package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class ForeclosedPropertySaleCard extends Card{

	public ForeclosedPropertySaleCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}