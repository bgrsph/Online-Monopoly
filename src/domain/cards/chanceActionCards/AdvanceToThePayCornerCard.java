package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;

public class AdvanceToThePayCornerCard extends Card {

	public AdvanceToThePayCornerCard() {
		super("chanceAction", true);
		
		
	}

	@Override
	public void useCard() {
		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		int currentSqIndex = currentPlayer.getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		Square targetSquare;
		
		if(currentPlayer.isInOuterTrack()) {
			targetSquare = MonopolyGameController.getBoard().getSquare("PaydaySquare");
			try {
				int targetSqIndex =  MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} else if(currentPlayer.isInCenterTrack()) {
			
			targetSquare = MonopolyGameController.getBoard().getSquare("Go");
			try {
				int targetSqIndex =  MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		} else {
			
			targetSquare = MonopolyGameController.getBoard().getSquare("BonusSquare");
			try {
				int targetSqIndex =  MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		

		
	}
	

}
