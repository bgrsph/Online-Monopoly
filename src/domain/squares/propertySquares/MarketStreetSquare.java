package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MarketStreetSquare extends DeedSquare {
	public MarketStreetSquare() {
		super("MarketStreetSquare", 0, 0, null, 420, 0, 250, 0, 250, 0, 250, "cream");
		this.rent[0]=55;
		this.rent[1]=225;
		this.rent[2]=630;
		this.rent[3]=1450;
		this.rent[4]=1750;
		this.rent[5]=2050;
		this.rent[6]=3550;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
