package domain.squares.railroadSquares;

import domain.MonopolyGameController;

public class ReadingRailroadSquare extends RailroadSquare {

	public ReadingRailroadSquare() {
		super("ReadingRailroadSquare", 0, 0, null, 200, null, 0, 0, false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
