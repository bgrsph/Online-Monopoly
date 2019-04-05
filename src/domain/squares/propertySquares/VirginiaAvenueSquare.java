package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class VirginiaAvenueSquare extends DeedSquare{

	public VirginiaAvenueSquare() {
		super("VirginiaAvenueSquare", 0, 0, null, 80, 0, 100, 0, 100, 0, 100, "pink");
		this.rent[0]=12;
		this.rent[1]=60;
		this.rent[2]=180;
		this.rent[3]=500;
		this.rent[4]=700;
		this.rent[5]=900;
		this.rent[6]=1400;
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
