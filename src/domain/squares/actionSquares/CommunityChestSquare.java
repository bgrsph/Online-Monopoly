package domain.squares.actionSquares;



import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.network.NetworkController;
import domain.squares.Square; 

public class CommunityChestSquare extends Square{

	
	
	
	public CommunityChestSquare() {
		super("CommunityChestSquare", 0, 0);
		// TODO Auto-generated constructor stub
	} 

	@Override
	public void landedOn() {
		
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		Card pulledCard = MonopolyGameController.getDeck().pickRandomCard("CommunityChestCard");
		Logger.getInstance().notifyAll(pulledCard.getName() + " was pulled from Community Chest Card Deck");
		NetworkController.getInstance().cardPulledInChanceOrCommunitySquareEvent(pulledCard.getName());
		
		if(!pulledCard.isDisposable()) {
			Logger.getInstance().notifyAll(currentPlayer.getName() + " pulled a storable card: " + pulledCard.getName());
			Logger.getInstance().notifyAll("Card will be stored in players card list.");
			currentPlayer.getCards().add(pulledCard);
			MonopolyGameController.updatePlayerScreen();
		}
		else {
			Logger.getInstance().notifyAll(currentPlayer.getName() + " pulled a disposible card: " + pulledCard.getName());
			
			pulledCard.useCard();
		}
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		 
	}

}
 