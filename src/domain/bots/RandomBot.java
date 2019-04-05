package domain.bots;


import java.util.ArrayList;

import java.util.Random;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;

public class RandomBot implements BotStrategy {

	private static double fractionPoint = 0.7;
	
	@Override
	public void buy(Bot B) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double x = r.nextDouble();
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		if(x < fractionPoint) {
			((Player) B).buy(currentSquare);
		}
		Logger.getInstance().notifyAll(B + " don't want to buy squares.");
	}

	@Override
	public void buildBuilding(Bot b) {
		// TODO Auto-generated method stub
		Random r2 = new Random();
		double y = r2.nextDouble();
		ArrayList<Square> A = b.getProperties();
		ArrayList<DeedSquare> C = new ArrayList<DeedSquare>();
		for(Square s: A) {
			if(s instanceof DeedSquare) {
				C.add((DeedSquare)s);
			}
		}
		if(y < fractionPoint) {
			if(C.isEmpty()) {
				Random r = new Random();
				int x = r.nextInt(C.size());
				C.get(x).upgrade();
			}
		}
	}

	@Override
	public void mortgage(Bot b) {
		// TODO Auto-generated method stub
		Random r2 = new Random();
		double y = r2.nextDouble();
		ArrayList<Square> A = b.getProperties();
		ArrayList<DeedSquare> C = new ArrayList<DeedSquare>();
		for(Square s: A) {
			if(s instanceof DeedSquare) {
				C.add((DeedSquare)s);
			}
		}
		if(y > fractionPoint) {
			if(C.isEmpty()) {
				Random r = new Random();
				int x = r.nextInt(C.size());
				C.get(x).mortgage();
			}
		}
	}

	@Override
	public void useCard(Bot b) {
		// TODO Auto-generated method stub
		
	}

}