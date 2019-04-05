package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class AuctionSquare extends Square {

	public AuctionSquare() {
		super("AuctionSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("Auction is excluded in this game!");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}
