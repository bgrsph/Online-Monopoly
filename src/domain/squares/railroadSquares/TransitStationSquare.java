package domain.squares.railroadSquares;

import domain.MonopolyGameController;
import domain.squares.Square;

public class TransitStationSquare extends Square{
	
	public TransitStationSquare() {
		super("TransitStationSquare", 0, 0);
	}



	

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
//		if(this.isOwned()) {
//			MonopolyGameController.allowCurrentPlayerToPayRent();
//		}else MonopolyGameController.allowCurrentPlayerToBuy();
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}
	
}
