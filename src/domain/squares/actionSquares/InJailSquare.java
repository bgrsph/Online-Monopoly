package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class InJailSquare extends Square {

	public InJailSquare() {
		super("InJailSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}
	
}
