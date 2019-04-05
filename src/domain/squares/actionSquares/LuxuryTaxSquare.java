 package domain.squares.actionSquares;


import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;


public class LuxuryTaxSquare extends Square{
 
		public LuxuryTaxSquare() {
		super("LuxuryTaxSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

		@Override
		public void landedOn() {
			// TODO Auto-generated method stub
			MonopolyGameController.getCurrentPlayer().decreaseMoney(75);
			Logger.getInstance().notifyAll("Luxury Tax has paid");
			MonopolyGameController.allowCurrentPlayerToEndTurn();
		}
	
		
		
}
