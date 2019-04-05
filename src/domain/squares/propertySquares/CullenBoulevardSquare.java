package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class CullenBoulevardSquare extends DeedSquare {
	public CullenBoulevardSquare() {
		super("CullenBoulevard", 0, 0, null, 180, 0, 100, 0, 100, 0, 100, "light yellow");
		this.rent[0]=14;
		this.rent[1]=70;
		this.rent[2]=200;
		this.rent[3]=550;
		this.rent[4]=750;
		this.rent[5]=950;
		this.rent[6]=1450;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
