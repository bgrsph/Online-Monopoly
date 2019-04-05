package domain.squares.actionSquares;
import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Passable;
import domain.squares.Square;
public class PayDaySquare extends Square implements Passable{
	 
	public PayDaySquare() {
		super("PayDaySquare", 0, 0);

	}
//action cardla gelme eklenecek
	public void landedOn() {
		MonopolyGameController.getInstance();
		if (MonopolyGameController.getCup().getTotalFaceValue() % 2 == 0) {
			MonopolyGameController.getCurrentPlayer().increaseMoney(400);
			Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName() + " gained 400 dollars by landing on Go Square");
		} else {
			MonopolyGameController.getCurrentPlayer().increaseMoney(300);
			Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName() + " gained 300 dollars by landing on Go Square");
		}
		MonopolyGameController.allowCurrentPlayerToEndTurn();
			
	}
	
	
	public void passedBy() {
		MonopolyGameController.getInstance();
		if (MonopolyGameController.getCup().getTotalFaceValue() % 2 == 0) {
			MonopolyGameController.getCurrentPlayer().increaseMoney(400);
			Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName() + " gained 400 dollars by landing on Go Square");
		} else {
			MonopolyGameController.getCurrentPlayer().increaseMoney(300);
			Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName() + " gained 300 dollars by landing on Go Square");
		}
	}
	public void landedWithMonop() {
		// TODO Auto-generated method stub
		MonopolyGameController.getCurrentPlayer().increaseMoney(400);
	}

}
