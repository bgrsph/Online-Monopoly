package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class VenturaBoulevardSquare extends DeedSquare {
	public VenturaBoulevardSquare() {
		super("VenturaBoulevard", 0, 0, null, 480, 0, 300, 0, 300, 0, 300, "earth");
		this.rent[0]=80;
		this.rent[1]=400;
		this.rent[2]=825;
		this.rent[3]=1800;
		this.rent[4]=2175;
		this.rent[5]=2550;
		this.rent[6]=4050;
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
