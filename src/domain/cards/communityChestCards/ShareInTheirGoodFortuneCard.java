package domain.cards.communityChestCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class ShareInTheirGoodFortuneCard extends Card{

	public ShareInTheirGoodFortuneCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
