package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class IllinoisAvenueSquare  extends DeedSquare {
	public IllinoisAvenueSquare() {
		
		super("IllinoisAvenueSquare", 0, 0, null, 240, 0, 150, 0, 150, 0, 150, "red");

			this.rent[0]=20;
			this.rent[1]=100;
			this.rent[2]=300;
			this.rent[3]=750;
			this.rent[4]=925;
			this.rent[5]=1100;
			this.rent[6]=2100;
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
