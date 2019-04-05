package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class StockExchangeSquare extends Square {

	public StockExchangeSquare() {
		super("StockExchangeSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Stock market is closed. Visit later.");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
