package domain.cards.communityChestCards;


import domain.MonopolyGameController;
import domain.cards.Card;

public class HappyBirthdayCard extends Card{

	public HappyBirthdayCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("static-access")
	@Override
	public void useCard() {
		
		try {
			MonopolyGameController.getInstance().handleHappyBirthdayCard(MonopolyGameController.getInstance().getCurrentPlayer());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
