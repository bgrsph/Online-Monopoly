package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class FishermansWharfSquare extends DeedSquare {
	

	public FishermansWharfSquare() {
		super("FishermansWharfSquare", 0, 0, null, 250, 0, 100, 0, 100, 0, 100, "white");
		this.rent[0]=21;
		this.rent[1]=105;
		this.rent[2]=320;
		this.rent[3]=780;
		this.rent[4]=950;
		this.rent[5]=1125;
		this.rent[6]=1625;

	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
