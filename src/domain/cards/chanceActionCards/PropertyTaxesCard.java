package domain.cards.chanceActionCards;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class PropertyTaxesCard extends Card{

	public PropertyTaxesCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}
