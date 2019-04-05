package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class NewburyStreetSquare extends DeedSquare {
	public NewburyStreetSquare() {
		super("NewburyStreet", 0, 0, null, 380, 0, 200, 0, 200, 0, 200, "black");
		this.rent[0]=40;
		this.rent[1]=185;
		this.rent[2]=550;
		this.rent[3]=1200;
		this.rent[4]=1500;
		this.rent[5]=1700;
		this.rent[6]=2700;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
