package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class RandolphStreetSquare extends DeedSquare {
	public RandolphStreetSquare() {
		super("RandolphStreetSquare", 0, 0, null, 270, 0, 150, 0, 150, 0, 150, "carmine");
		this.rent[0]=23;
		this.rent[1]=115;
		this.rent[2]=345;
		this.rent[3]=825;
		this.rent[4]=1010;
		this.rent[5]=1180;
		this.rent[6]=2180;
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

