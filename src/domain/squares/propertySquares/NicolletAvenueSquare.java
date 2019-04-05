package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class NicolletAvenueSquare extends DeedSquare {
	public NicolletAvenueSquare() {
		super("NicolletAvenue", 0, 0, null, 30, 0, 50, 0, 50, 0, 50, "light pink");
		this.rent[0]=1;
		this.rent[1]=5;
		this.rent[2]=15;
		this.rent[3]=45;
		this.rent[4]=80;
		this.rent[5]=125;
		this.rent[6]=625;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
