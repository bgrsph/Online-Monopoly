package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class ReverseDirectionSquare extends Square {

	public ReverseDirectionSquare() {
		super("ReverseDirectionSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer().reversetDirection();
		Logger.getInstance().notifyAll("Direction is reversed");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
