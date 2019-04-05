package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class EsplanadeAvenueSquare extends DeedSquare {
	public EsplanadeAvenueSquare() {
		super("EsplanadeAvenue", 0, 0, null, 90, 0, 50, 0, 50, 0, 50, "light green");
		this.rent[0]=5;
		this.rent[1]=25;
		this.rent[2]=80;
		this.rent[3]=225;
		this.rent[4]=360;
		this.rent[5]=600;
		this.rent[6]=1000;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
