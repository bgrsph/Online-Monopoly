package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class FreeParkingSquare extends Square {

	public FreeParkingSquare() {
		super("FreeParkingSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Parked freely.");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}
	
}
