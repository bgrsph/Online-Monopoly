package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class WestTempleSquare extends DeedSquare {
	public WestTempleSquare() {
		super("WestTempleSquare", 0, 0, null, 330, 0, 200, 0, 200, 0, 200, "olive");
		this.rent[0]=32;
		this.rent[1]=160;
		this.rent[2]=470;
		this.rent[3]=1050;
		this.rent[4]=1250;
		this.rent[5]=1500;
		this.rent[6]=2500;
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

