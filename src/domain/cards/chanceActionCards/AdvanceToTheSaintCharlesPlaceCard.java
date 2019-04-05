package domain.cards.chanceActionCards;

import domain.Logger;
import domain.MonopolyGameController;
import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;

public class AdvanceToTheSaintCharlesPlaceCard extends Card{

	public AdvanceToTheSaintCharlesPlaceCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
	if(((DeedSquare) MonopolyGameController.getBoard().getSquare("StCharlesPlaceSquare")).getOwner() != null) {
		MonopolyGameController.getInstance().getCurrentPlayer().payRent(MonopolyGameController.getBoard().getSquare("StCharlesPlaceSquare"));
	}else if(((DeedSquare) MonopolyGameController.getBoard().getSquare("StCharlesPlaceSquare")).getOwner() == null){
		Logger.getInstance().notifyAll(MonopolyGameController.getInstance().getCurrentPlayer().getName() + " is in StCharlesPlace, he/she may buy this square.");
	}
		
		
		
		
	}
	
	

}