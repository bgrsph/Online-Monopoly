package domain.bots;

import java.util.ArrayList;
import java.util.Random;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;

public class GreedyBot implements BotStrategy {

	

	@Override
	public void buy(Bot B) {
		// TODO Auto-generated method stub
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		((Player) B).buy(currentSquare);
	}

	@Override
	public void mortgage(Bot B) {
		// TODO Auto-generated method stub
		
		if(B.getBalance()<100) {
			Logger.getInstance().notifyAll("Ben fantastik bir robotum");
		} else {
			Logger.getInstance().notifyAll("I'm a GreedyBot, won't mortgage anything");
		}
		
	}

	@Override
	public void useCard(Bot B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildBuilding(Bot B) {
		// TODO Auto-generated method stub
		ArrayList <Square> A=B.getProperties();
		ArrayList <DeedSquare> C= new ArrayList<DeedSquare>();

		for(Square s: A) {
			if(s instanceof DeedSquare) {
				C.add((DeedSquare) s);
			}
		}
		if(!C.isEmpty()) {
			Random r= new Random();
			int x= r.nextInt(C.size());
			C.get(x).upgrade();
		}
	}

}
