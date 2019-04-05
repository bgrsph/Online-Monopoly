package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class PayBackCard extends Card{

	public PayBackCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
		MonopolyGameController mp = MonopolyGameController.getInstance();
	//MonopolyGameController.getInstance().goToJail();
//		mp.getCurrentPlayer().setInJail(true);
		if(MonopolyGameController.getInstance().getCurrentPlayer().getProperties()== null) {
			return;
		}else {
			mp.getCurrentPlayer().payRent(mp.getCurrentPlayer().getCurrentSquare(mp.getBoard()));
		}
	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}
