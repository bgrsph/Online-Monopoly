package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class BusTicketSquare extends Square {

	public BusTicketSquare() {
		super("BusTicketSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Bus Ticket is excluded in this game!");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
