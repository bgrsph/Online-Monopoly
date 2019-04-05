package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MagazineStreetSquare extends DeedSquare {
	public MagazineStreetSquare() {
		super("MagazineStreet", 0, 0, null, 120, 0, 50, 0, 50, 0, 50, "light green");
		this.rent[0]=8;
		this.rent[1]=40;
		this.rent[2]=100;
		this.rent[3]=300;
		this.rent[4]=450;
		this.rent[5]=600;
		this.rent[6]=1100;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
