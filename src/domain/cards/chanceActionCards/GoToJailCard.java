package domain.cards.chanceActionCards;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;

public class GoToJailCard extends Card{

	public GoToJailCard() {
		super("chanceAction", true);
	
	}

	@Override
	public void useCard() {
		
		
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		int currentSquareIndex = currentPlayer.getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSquareIndex);
		Square targetSquare = MonopolyGameController.getBoard().getSquare("InJailSquare");
		int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);

		if(currentPlayer.isInJail()) {
			
			Logger.getInstance().notifyAll(currentPlayer.getName() + " is already in jail.");
			return;
		} else {
		
			try {
				Logger.getInstance().notifyAll(currentPlayer.getName() + " is now in jail.");
				
				currentPlayer.nowInJail();		
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
			} catch (InterruptedException e) {
				System.out.println("Something wrong with GoToJailCard");
				e.printStackTrace();
			}
		}
		
		
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		
		
		
	}
}