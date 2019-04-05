package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class MarvinGardensSquare extends DeedSquare {
	public MarvinGardensSquare () {
		super("MarvinGardensSquare", 0, 0, null, 280, 0, 150, 0, 150, 0, 150, "yellow");

			this.rent[0]=24;
			this.rent[1]=120;
			this.rent[2]=350;
			this.rent[3]=850;
			this.rent[4]=1025;
			this.rent[5]=1200;
			this.rent[6]=2200;
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
