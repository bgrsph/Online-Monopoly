package domain.cards.communityChestCards;

import domain.MonopolyGameController;
import domain.cards.Card;

public class PayHospitalBillsCard extends Card{

	public PayHospitalBillsCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.getPool().setPoolMoney(100);
		MonopolyGameController.getCurrentPlayer().decreaseMoney(100);
		
	}

}
