package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;

public class SocialMediaFailCard extends Card{

	public SocialMediaFailCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
		for(Player p: MonopolyGameController.getPlayers()) {
			if(!(p.getName().equals(MonopolyGameController.getCurrentPlayer()))){
				p.increaseMoney(50);
			}else {
				p.decreaseMoney(50*(MonopolyGameController.getPlayers().size()-1));
			}
		}
		
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}