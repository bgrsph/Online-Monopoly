package domain.cards.chanceActionCards;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class GetOutJailFreeCard extends Card{

	public GetOutJailFreeCard() {
		super("chanceAction", false);
	}

	@Override
	public void useCard() {
		
	
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		
		if(currentPlayer.getCards().contains(this)) {
			
			if(currentPlayer.isInJail()) {
				Logger.getInstance().notifyAll(currentPlayer.getName() + "is out of jail now.");
				currentPlayer.getCards().remove(this);
				currentPlayer.setInJail(0);
				MonopolyGameController.updatePlayerScreen();
				MonopolyGameController.getInstance().getDeck().getChanceActionCards().add(this);
				Logger.getInstance().notifyAll(this.getClass().getSimpleName() + " is in deck now.");
				
			} else {		
				Logger.getInstance().notifyAll(currentPlayer.getName() + " is not in jail, he/she can't use this card");
			}
		}
		
	}
}