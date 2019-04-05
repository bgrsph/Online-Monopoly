package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class PennsylvaniaAvenueSquare  extends DeedSquare {
	public PennsylvaniaAvenueSquare() {
		
	super("PennsylvaniaAvenueSquare ", 0, 0, null, 320, 0, 200, 0, 200, 0, 200, "green");

		this.rent[0]=28;
		this.rent[1]=150;
		this.rent[2]=450;
		this.rent[3]=1000;
		this.rent[4]=1200;
		this.rent[5]=1400;
		this.rent[6]=2400;
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
