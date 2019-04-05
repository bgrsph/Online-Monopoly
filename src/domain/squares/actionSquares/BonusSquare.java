package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Passable;
import domain.squares.Square;

public class BonusSquare extends Square implements Passable{

	public BonusSquare() {
		super("BonusSquare", 0, 0);
		
	} 

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer().increaseMoney(300);
		Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName()+ " gained 300 dollars by landing on Bonus Square");
		MonopolyGameController.allowCurrentPlayerToEndTurn();

	}

	@Override
	public void passedBy() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer().increaseMoney(250);
		Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName()+ " gained 250 dollars by landing on Bonus Square");

	}
	
	

}
