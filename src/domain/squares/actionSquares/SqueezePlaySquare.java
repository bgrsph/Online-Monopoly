package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class SqueezePlaySquare extends Square {

	public SqueezePlaySquare() {
		super("SqueezePlaySquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Squeeze Play is excluded in this game!");
		MonopolyGameController.allowCurrentPlayerToEndTurn();

	}

}
