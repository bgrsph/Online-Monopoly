package domain.cards.communityChestCards;

import java.util.ArrayList;
import java.util.Random;

import domain.Logger;
import domain.MonopolyGameController;
import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;

public class HouseCondemnedCard extends Card {

	public HouseCondemnedCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		ArrayList<DeedSquare> d= new ArrayList<DeedSquare>();
		for(Square s1: MonopolyGameController.getCurrentPlayer().getProperties()) {
			if(s1 instanceof DeedSquare) {
				if(((DeedSquare) s1).getNumberOfHouses()>=1) {
					d.add((DeedSquare) s1);
				}
			}
		}
		if(!d.isEmpty()) {
			d.get(0);
		} else {
			Logger.getInstance().notifyAll("Nothing done since there are no house");
		}

	
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

}