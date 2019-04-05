package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class BirthdayGiftSquare extends Square {

	public BirthdayGiftSquare() {
		super("BirthdayGiftSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Bus ticket is excluded in this game!");
		Logger.getInstance().notifyAll("So, you deserve 100 dollars as birthday gift");
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer().increaseMoney(100);
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
 