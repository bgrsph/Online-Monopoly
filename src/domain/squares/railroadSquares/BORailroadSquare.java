package domain.squares.railroadSquares;

import domain.MonopolyGameController;

public class BORailroadSquare extends RailroadSquare{


	int[] rent = new int[4];
	
	public BORailroadSquare() {
		
		super("BORailroadSquare", 0, 0, null, 200, null, 0, 0, false);
		this.rent[0] = 25;
		this.rent[1] = 50;
		this.rent[2] = 100;
		this.rent[3] = 200;
		
	}
		
	

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();
	} 



	@Override
	public void buyTrainDepot() {
		// TODO Auto-generated method stub
		super.buyTrainDepot();
	}


	@Override
	public void sellTrainDepots() {
		// TODO Auto-generated method stub
		super.sellTrainDepots();
	}


	
}







