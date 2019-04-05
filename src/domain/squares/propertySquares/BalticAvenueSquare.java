package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class BalticAvenueSquare extends DeedSquare {
	

	public BalticAvenueSquare() {
		
		super("BalticAvenueSquare", 0, 0, null, 30, 0, 50, 0, 50, 0, 50, "damson");
		
		this.rent[0]=4;
		this.rent[1]=20;
		this.rent[2]=60;
		this.rent[3]=180;
		this.rent[4]=320;
		this.rent[5]=450;
		this.rent[6]=90;
		

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
