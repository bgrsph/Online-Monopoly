package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class VentnorAvenueSquare  extends DeedSquare  {
	public VentnorAvenueSquare() {
		super("VentnorAvenueSquare", 0, 0, null, 260, 0, 150, 0, 150, 0, 150, "yellow");

			this.rent[0]=22;
			this.rent[1]=110;
			this.rent[2]=330;
			this.rent[3]=800;
			this.rent[4]=975;
			this.rent[5]=1150;
			this.rent[6]=2150;
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
