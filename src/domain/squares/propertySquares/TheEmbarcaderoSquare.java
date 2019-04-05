package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class TheEmbarcaderoSquare extends DeedSquare {
	public TheEmbarcaderoSquare() {
		super("TheEmbarcadero", 0, 0, null, 210, 0, 100, 0, 100, 0, 100, "white");
		this.rent[0]=17;
		this.rent[1]=85;
		this.rent[2]=240;
		this.rent[3]=475;
		this.rent[4]=670;
		this.rent[5]=1025;
		this.rent[6]=1525;


	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
