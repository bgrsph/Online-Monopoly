package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class StCharlesPlaceSquare extends DeedSquare {
	public StCharlesPlaceSquare() {
		super("StCharlesPlaceSquare", 0, 0, null, 70, 0, 100, 0, 100, 0, 100, "pink");
		this.rent[0]=10;
		this.rent[1]=50;
		this.rent[2]=150;
		this.rent[3]=450;
		this.rent[4]=625;
		this.rent[5]=750;
		this.rent[6]=1250;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();
	}
	
	public void payRent() {
		
	}
}
