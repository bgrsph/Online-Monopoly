package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class BroadStreetSquare extends DeedSquare {
	public BroadStreetSquare() {
		super("BroadStreet", 0, 0, null, 390, 0, 250, 0, 250, 0, 250, "cream");
		this.rent[0]=45;
		this.rent[1]=210;
		this.rent[2]=575;
		this.rent[3]=1300;
		this.rent[4]=1600;
		this.rent[5]=1800;
		this.rent[6]=3300;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
