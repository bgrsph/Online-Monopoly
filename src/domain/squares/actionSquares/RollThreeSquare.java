package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class RollThreeSquare extends Square {
	

		public RollThreeSquare() {
			super("RollThreeSquare", 0, 0);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void landedOn() {
			Logger.getInstance().notifyAll("Roll 3 Square is excluded in this game!");
			MonopolyGameController.allowCurrentPlayerToEndTurn();
		}

		
}
