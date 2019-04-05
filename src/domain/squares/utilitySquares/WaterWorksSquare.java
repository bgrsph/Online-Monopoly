package domain.squares.utilitySquares;
import domain.MonopolyGameController;

public class WaterWorksSquare extends UtilitySquare {

		public WaterWorksSquare() {
			super("WaterWorksSquare", 0, 0);
			// TODO Auto-generated constructor stub
		}

	 
		@Override
		public void landedOn() {
			// TODO Auto-generated method stub
			if(this.isOwned()) {
				MonopolyGameController.allowCurrentPlayerToPayRent();
			}else MonopolyGameController.allowCurrentPlayerToBuy();
		}
				
}