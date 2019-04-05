package ui;

import domain.Player;
import domain.squares.Square;

public class Facade {
	
	
	private static Facade facadeInstance;


	private Facade() {

	}

	public static Facade getInstance() {

		if (facadeInstance == null) {
			facadeInstance = new Facade();
		}

		return facadeInstance;
	}
 
	
	public void teleport(Player cardOwnerPlayer, String sourceSquareName, String targetSquareName, int targetSquareIndex) throws InterruptedException {
		
		String playerPawnName = cardOwnerPlayer.getPawn().getName();
		MonopolyGameFrame.getInstance().teleportPawnImage(playerPawnName,sourceSquareName, targetSquareName, targetSquareIndex);
	}
	
	 
	public String squareTypeExtractor() {
		return "NoType";
	}

	public String colorTypeExtractor() {
		return MonopolyGameFrame.getInstance().pickColorTypeCombo();
	}

	public Square squaresForSubway() {
		return MonopolyGameFrame.getInstance().getSquaresForSubway();
	}
	
	public int squaresIndexForSubway() {
		return MonopolyGameFrame.getInstance().getSquaresIndexForSubway();
	}
	
	
	
	
	public static void notifyPlayers(String msg) {

		MonopolyGameFrame.getInstance().writeOnGameLog(msg);
		
	}
	public static void clearLog() {
		MonopolyGameFrame.getInstance().clearGameLog();
		
	}

	public void switchButtonsToStartStateForPlayerInTurn() {
		MonopolyGameFrame.getInstance().switchButtonsToStartStateForPlayerInTurn();
		
	}

	public void switchButtonsToStartStateForPlayerNotInTurn() {
		MonopolyGameFrame.getInstance().switchButtonsToStartStateForPlayerNotInTurn();
		
	}

	public void switchButtonsToAfterRollDiceState() {
		MonopolyGameFrame.getInstance().switchButtonsToAfterRollDiceState();
		
	}

	public void startRollDiceAnimation() {
		MonopolyGameFrame.getInstance().startRollDiceAnimation();
		
	}

	public void switchButtonsToAfterEndTurnPressed() {
		MonopolyGameFrame.getInstance().switchButtonsToAfterEndTurnPressed();
		
	}

	public void switchButtonsToPlayerInTurnState() {
		MonopolyGameFrame.getInstance().switchButtonsToPlayerInTurnState();
		
	}
	

	public void allowCurrentPlayerToBuy() {
		
		MonopolyGameFrame.getInstance().switchToBuyState();

	}
	

	public void switchButtonsToAfterBuyState() {
		MonopolyGameFrame.getInstance().switchButtonsToAfterBuyState();
		
	}

	public void allowNotCurrentPlayerToNotBuy() {
		MonopolyGameFrame.getInstance().allowNotCurrentPlayerToNotBuy();
		
	}

	public void showPlayerStatus() {
		MonopolyGameFrame.getInstance().showPlayerStatus();
		
	} 

	public void disableInteractions() {
		MonopolyGameFrame.getInstance().disableInteractions();
		
	}

	public void switchGameToPauseState() {
		MonopolyGameFrame.getInstance().switchGameToPauseState();
		
	}

	public void switchGameToResumeState() {
		MonopolyGameFrame.getInstance().switchGameToResumeState();
		
	}

	public void allowCurrentPlayerToPayRent() {
		MonopolyGameFrame.getInstance().allowCurrentPlayerToPayRent();
		
	}

	public void switchButtonsToAfterRentState() {
		MonopolyGameFrame.getInstance().switchButtonsToAfterRentState();
		
	}

	public void switchButtonsToPlayAgainState() {
		
		MonopolyGameFrame.getInstance().switchButtonsToPlayAgainState();
	}

	
	public void switchButtonsToEndTurnState() {
		
		MonopolyGameFrame.getInstance().switchButtonsToEndTurnState();
		
	}

	public void switchButtonsToSpecialMoveState() {
		
		MonopolyGameFrame.getInstance().switchButtonsToSpecialMoveState();
	}

	public void giveInvalidPressOfUseCardButtonError() {
		MonopolyGameFrame.getInstance().giveInvalidPressOfUseCardButtonError();
		
	}

	public void informPlayerToSelectDesiredSquare() {
		MonopolyGameFrame.getInstance().informPlayerToSelectDesiredSquare();
		
	}

	public String getSelectedSquareNameFromUser() {
		
		
		String res = MonopolyGameFrame.getInstance().getSelectedSquareFromUser();
		System.out.println("In the Facade: returning :" + res );
		return res;
		
	}

	public void switchButtonsToTriplesState() {
		MonopolyGameFrame.getInstance().switchButtonsToTriplesState();
		
	}

	public void updatePlayerScreen() {
		MonopolyGameFrame.getInstance().updatePlayerScreen();
		
	}

	public void switchButtonsToAfterTriplesState() {
		MonopolyGameFrame.getInstance().switchButtonsToAfterTriplesState();
		
	} 

	public void closeEndTurn() {
		MonopolyGameFrame.getInstance().closeEndTurn();
		
	}

	public void riseDialog(String string) {
		MonopolyGameFrame.getInstance().riseDialog(string);
		
	}

	public String getSelectedSquareType() {
		
		return MonopolyGameFrame.getInstance().getSelectedSquareType();
	}

	public String getSelectedColorType() {
		// TODO Auto-generated method stub
		return MonopolyGameFrame.getInstance().getSelectedColorType();
	}




	
	
	
	
	
	
	
	
	

	
}
