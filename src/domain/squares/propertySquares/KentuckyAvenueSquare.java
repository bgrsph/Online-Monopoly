package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class KentuckyAvenueSquare  extends DeedSquare  {
	public KentuckyAvenueSquare() {
		
		super("KentuckyAvenueSquare", 0, 0, null, 220, 0, 150, 0, 150, 0, 150, "red");

			this.rent[0]=18;
			this.rent[1]=90;
			this.rent[2]=250;
			this.rent[3]=700;
			this.rent[4]=875;
			this.rent[5]=1050;
			this.rent[6]=2050;
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
