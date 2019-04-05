package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class GpsIsNotWorkingCard extends Card{

	public GpsIsNotWorkingCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}