package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class NorthCarolinaAvenueSquare extends DeedSquare {
	public NorthCarolinaAvenueSquare () {
		super("NorthCarolinaAvenueSquare", 0, 0, null, 300, 0, 200, 0, 200, 0, 200, "green");

			this.rent[0]=26;
			this.rent[1]=130;
			this.rent[2]=390;
			this.rent[3]=900;
			this.rent[4]=1100;
			this.rent[5]=1275;
			this.rent[6]=2275;
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
