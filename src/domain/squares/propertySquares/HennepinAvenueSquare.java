package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class HennepinAvenueSquare extends DeedSquare {
	public HennepinAvenueSquare() {

		super("HennepinAvenue", 0, 0, null, 60, 0, 50, 0, 50, 0, 50, "light pink");
		this.rent[0]=3;
		this.rent[1]=15;
		this.rent[2]=45;
		this.rent[3]=120;
		this.rent[4]=240;
		this.rent[5]=350;
		this.rent[6]=850;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
