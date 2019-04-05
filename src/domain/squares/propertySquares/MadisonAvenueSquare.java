package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MadisonAvenueSquare extends DeedSquare {
	public MadisonAvenueSquare() {
		super("MaidosonAvenue", 0, 0, null, 340, 0, 300, 0, 300, 0, 300, "grey");
		this.rent[0]=60;
		this.rent[1]=220;
		this.rent[2]=650;
		this.rent[3]=1500;
		this.rent[4]=1800;
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
