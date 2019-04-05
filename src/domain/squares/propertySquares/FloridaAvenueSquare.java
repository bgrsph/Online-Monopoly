package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class FloridaAvenueSquare extends DeedSquare {
	
	
	public FloridaAvenueSquare() {
		
		//price will be changed
		super("FloridaAvenueSquare", 0, 0, null, 130, 0, 50, 0, 50, 0, 50, "brown");
		this.rent[0]=9;
		this.rent[1]=45;
		this.rent[2]=120;
		this.rent[3]=350;
		this.rent[4]=500;
		this.rent[5]=700;
		this.rent[6]=1200;
	
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
