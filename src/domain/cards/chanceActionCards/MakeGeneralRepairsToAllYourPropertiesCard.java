package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class MakeGeneralRepairsToAllYourPropertiesCard extends Card{

	public MakeGeneralRepairsToAllYourPropertiesCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}
