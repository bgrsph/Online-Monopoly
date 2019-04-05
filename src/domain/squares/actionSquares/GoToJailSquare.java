package domain.squares.actionSquares;


import domain.Logger;
import domain.MonopolyGameController;
import domain.squares.Square;
import ui.Facade;

public class GoToJailSquare extends Square {
	
	public GoToJailSquare(){
		super("GoToJailSquare", 0, 0);	
	}
	
	
	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Logger.getInstance().notifyAll("You arrested!");
		MonopolyGameController.getInstance();
		MonopolyGameController.getCurrentPlayer().setInJail(3);
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		//current index'i injaile e˛itleyip oraya teleport ettiricez
		Square jailSquare = MonopolyGameController.getBoard().getSquare("InJailSquare");
		MonopolyGameController.getCurrentPlayer().setCurrentSquareIndex(MonopolyGameController.getInstance().getBoard().getSquareList().indexOf(jailSquare));
		try {
			MonopolyGameController.teleportPlayer(MonopolyGameController.getCurrentPlayer(), this, jailSquare, MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MonopolyGameController.getCurrentPlayer().nowInJail();
		
	}
	
	
}
