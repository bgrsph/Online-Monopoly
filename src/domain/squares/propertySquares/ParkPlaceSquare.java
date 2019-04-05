package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class ParkPlaceSquare extends DeedSquare {
	public ParkPlaceSquare () {
		
		super("ParkPlaceSquare", 0, 0, null, 350, 0, 200, 0, 200, 0, 200, "blue");

			this.rent[0]=35;
			this.rent[1]=175;
			this.rent[2]=500;
			this.rent[3]=1100;
			this.rent[4]=1300;
			this.rent[5]=1500;
			this.rent[6]=2500;
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
