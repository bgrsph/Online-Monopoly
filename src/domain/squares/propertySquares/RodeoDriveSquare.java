package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class RodeoDriveSquare extends DeedSquare {
	public RodeoDriveSquare() {
		super("RodeoDrive", 0, 0, null, 510, 0, 300, 0, 300, 0, 300, "earth");
		this.rent[0]=90;
		this.rent[1]=450;
		this.rent[2]=900;
		this.rent[3]=2000;
		this.rent[4]=2500;
		this.rent[5]=3000;
		this.rent[6]=4500;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
