package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class WallStreetSquare extends DeedSquare {
	public WallStreetSquare() {
		super("WallStreet", 0, 0, null, 500, 0, 300, 0, 300, 0, 300, "grey");
		this.rent[0]=80;
		this.rent[1]=300;
		this.rent[2]=800;
		this.rent[3]=1800;
		this.rent[4]=2200;
		this.rent[5]=2700;
		this.rent[6]=4200;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
