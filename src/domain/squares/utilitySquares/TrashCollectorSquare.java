package domain.squares.utilitySquares;

import domain.MonopolyGameController;

public class TrashCollectorSquare extends UtilitySquare {


	public TrashCollectorSquare() {
		
		super("TrashCollectorSquare", 0, 0);
	


	}




	public void landedOn(MonopolyGameController controller) {
		System.out.println("Landed On Trash Collector");


	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		if(this.isOwned()) {
			MonopolyGameController.allowCurrentPlayerToPayRent();
		}else MonopolyGameController.allowCurrentPlayerToBuy();
	}








}




