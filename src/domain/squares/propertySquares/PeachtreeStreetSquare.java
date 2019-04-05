package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class PeachtreeStreetSquare extends DeedSquare {
	public PeachtreeStreetSquare() {
		super("PeachtreeStreetSquare", 0, 0, null, 240, 0, 100, 0, 100, 0, 100, "dark green");
		this.rent[0]=20;
		this.rent[1]=100;
		this.rent[2]=300;
		this.rent[3]=750;
		this.rent[4]=925;
		this.rent[5]=1100;
		this.rent[6]=1600;
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

