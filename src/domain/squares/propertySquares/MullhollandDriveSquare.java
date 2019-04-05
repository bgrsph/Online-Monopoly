package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MullhollandDriveSquare extends DeedSquare {
	public MullhollandDriveSquare() {
		super("MullhollandDrive", 0, 0, null, 450, 0, 300, 0, 300, 0, 300, "earth");
		this.rent[0]=70;
		this.rent[1]=350;
		this.rent[2]=750;
		this.rent[3]=1600;
		this.rent[4]=1850;
		this.rent[5]=2100;
		this.rent[6]=3600;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
