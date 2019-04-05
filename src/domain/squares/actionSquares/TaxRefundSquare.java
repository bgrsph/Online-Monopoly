
package domain.squares.actionSquares;
import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;
public class TaxRefundSquare extends Square{
	
	public TaxRefundSquare() {
		super("TaxRefundSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		MonopolyGameController.getPool().splitMoneyAndDecreaseMoney();
		MonopolyGameController.getCurrentPlayer().increaseMoney((int) MonopolyGameController.getPool().getPoolMoney());
		Logger.getInstance().notifyAll(MonopolyGameController.getCurrentPlayer().getName()+" gained from tax refund square");
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}
}