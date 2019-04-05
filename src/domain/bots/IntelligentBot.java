package domain.bots;

import java.util.ArrayList;

import java.util.Random;

import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;
import domain.squares.utilitySquares.UtilitySquare;

public class IntelligentBot implements BotStrategy{


	@Override
	public void buy(Bot B) {
		// TODO Auto-generated method stub
		// e�er o tapu de�eri, paras�n�n 4 te birinden azsa al yoksa alma.
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		
		if(currentSquare instanceof DeedSquare) {
			
			if((((Player) B).getBalance()/4) > ((DeedSquare) currentSquare).getPrice()) {
				((Player) B).buy(currentSquare);
			}
		}
		
		else if(currentSquare instanceof UtilitySquare) {
			
			 if((((Player) B).getBalance()/4) > ((UtilitySquare) currentSquare).getPrice()) {
				((Player) B).buy(currentSquare);
			}
			
		}

		else if(currentSquare instanceof RailroadSquare) {
			if((((Player) B).getBalance()/4) > ((RailroadSquare) currentSquare).getPrice()) {
				((Player) B).buy(currentSquare);
			}
		}

	}

	@Override
	public void mortgage(Bot B) {
		// TODO Auto-generated method stub
		if(B.getBalance()<320) {
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
				C.get(x).mortgage();
			}
		}
	}		
	

	@Override
	public void useCard(Bot B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildBuilding(Bot B) {
		// TODO Auto-generated method stub
		Random r2= new Random();
		double y= r2.nextDouble();
		if(y>0.5) {
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

}
