package domain.cards.chanceActionCards;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class HolidayBonusCard extends Card {

	public HolidayBonusCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		currentPlayer.increaseMoney(100);
		

		Logger.getInstance().notifyAll(currentPlayer.getName() + " pulled Holiday Bonus Card (+ 100 balance)");

		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
		
	}

}
