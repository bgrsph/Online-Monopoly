package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Passable;
import domain.squares.Square;

public class GoSquare extends Square implements Passable{

	public GoSquare() {
		super("Go", 700, 700);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		currentPlayer.increaseMoney(200);
		Logger.getInstance().notifyAll(currentPlayer.getName() + " gained 200 dollars by landing on Go Square");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

	@Override
	public void passedBy() {
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		currentPlayer.increaseMoney(200);
		Logger.getInstance().notifyAll(currentPlayer.getName() + " gained 200 dollars by passing on Go Square");
	}
}
