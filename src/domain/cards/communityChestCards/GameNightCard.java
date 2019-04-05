package domain.cards.communityChestCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class GameNightCard extends Card{

	public GameNightCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		//UI'den rakip seçti
		
	}
	
	public void useCard(Player p) {
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer();
	}
	
}
