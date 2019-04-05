package domain.squares.propertySquares;

import domain.MonopolyGameController;

public class BoardwalkSquare  extends DeedSquare {
	static int[] rent = new int[]{50,200,600,1400,1700,2000,3000};
	public BoardwalkSquare() {
		
		super("BoardwalkSquare", 0, 0, null, 400, 0, 200, 0, 200, 0, 200, "blue");

			this.hotelPrice+=this.hotelPrice + (4*this.housePrice);
			this.SkyScraperPrice+= hotelPrice;
	}
		@Override
		public void landedOn() {
			if(this.isOwned()) {
				MonopolyGameController.allowCurrentPlayerToPayRent();
			}else MonopolyGameController.allowCurrentPlayerToBuy();

		}
		
		
}
