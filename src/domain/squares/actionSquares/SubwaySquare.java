package domain.squares.actionSquares;

import domain.MonopolyGameController;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import ui.Facade;

public class SubwaySquare extends Square {

	public SubwaySquare() {
		super("SubwaySquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		
		/*
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		//square selector panelden Áekicek
		Square sq=MonopolyGameController.selectSquare();
		
		
		
		
		MonopolyGameController.getCurrentPlayer().setCurrentSquareIndex(MonopolyGameController.getInstance().getBoard().getSquareList().indexOf(sq));
		try {
			MonopolyGameController.teleportPlayer(MonopolyGameController.getCurrentPlayer(), this, sq, MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(sq instanceof DeedSquare) {
			MonopolyGameController.getCurrentPlayer().buy((DeedSquare) sq);
		}
		else if(sq instanceof PayDaySquare) {
			MonopolyGameController.getCurrentPlayer().increaseMoney(150);
		} else sq.landedOn();
		
		
		*/
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}
	
	


}
