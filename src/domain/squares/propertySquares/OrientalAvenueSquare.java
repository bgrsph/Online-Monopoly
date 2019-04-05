package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class OrientalAvenueSquare extends DeedSquare {
	public OrientalAvenueSquare() {
		super("OrientalAvenueSquare", 0, 0, null, 50, 0, 50, 0, 50, 0, 50, "light blue");
		
		this.rent[0]=6;
		this.rent[1]=30;
		this.rent[2]=90;
		this.rent[3]=270;
		this.rent[4]=400;
		this.rent[5]=550;
		this.rent[6]=1050;
		
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
