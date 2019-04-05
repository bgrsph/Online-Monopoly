package domain.cards.communityChestCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class TheInsidersEdgeCard extends Card{

	public TheInsidersEdgeCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}
//inner 39-62
//outer 63-118
	
	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		if(MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex()<=62
				&& MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex()>=39) {
				MonopolyGameController.getCurrentPlayer().increaseMoney(250);
		}
		else if(63<=MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex()
				&& MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex()>=118) {
			MonopolyGameController.getPool().setPoolMoney(50);;
		}
		MonopolyGameController.allowCurrentPlayerToEndTurn();

	}

}
