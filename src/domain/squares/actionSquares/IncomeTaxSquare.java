package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;

public class IncomeTaxSquare extends Square {

	
	public IncomeTaxSquare() {
		super("IncomeTaxSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	//or 10% bolumunu ogren
	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		MonopolyGameController.getCurrentPlayer().decreaseMoney(200);
		Logger.getInstance().notifyAll("Income Tax has paid");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	
	}
}
