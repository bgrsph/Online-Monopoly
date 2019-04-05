package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class TenesseeAvenueSquare extends DeedSquare{

	public TenesseeAvenueSquare() {
		super("TenesseeAvenueSquare", 0, 0, null,90, 0, 100, 0, 100, 0, 100, "orange");
		this.rent[0]=14;
		this.rent[1]=70;
		this.rent[2]=200;
		this.rent[3]=550;
		this.rent[4]=750;
		this.rent[5]=950;
		this.rent[6]=1450;
		// TODO Auto-generated constructor stub
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
