package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MediterraneanAvenueSquare extends  DeedSquare {

	public MediterraneanAvenueSquare() {
		super("MediterraneanAvenueSquare", 0, 0, null, 30, 0, 50, 0, 50, 0, 50, "damson");
		
		this.rent[0]=2;
		this.rent[1]=10;
		this.rent[2]=30;
		this.rent[3]=90;
		this.rent[4]=160;
		this.rent[5]=250;
		this.rent[6]=750;
		
		
	}

	
	@Override
	public void landedOn() {
		
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

		
	}
	
	public void payRent() {
		
	}
}
