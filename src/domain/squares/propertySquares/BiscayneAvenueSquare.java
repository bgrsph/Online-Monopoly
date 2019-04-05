package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class BiscayneAvenueSquare extends DeedSquare {
	public BiscayneAvenueSquare() {
		super("BiscayneAvenue", 0, 0, null, 150, 0, 50, 0, 50, 0, 50, "brown");
		this.rent[0]=11;
		this.rent[1]=55;
		this.rent[2]=160;
		this.rent[3]=475;
		this.rent[4]=650;
		this.rent[5]=800;
		this.rent[6]=1300;
		this.hotelPrice+=this.hotelPrice + (4*this.housePrice);
		this.SkyScraperPrice+= hotelPrice;
		
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();

	}

}
