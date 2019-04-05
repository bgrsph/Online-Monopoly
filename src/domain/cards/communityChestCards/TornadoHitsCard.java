package domain.cards.communityChestCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;

public class TornadoHitsCard extends Card {

	public TornadoHitsCard() {
		super("communityChest", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		//UI inputlar�
		String sqt=null;
		String clr=null;
		//this.useCard(sqt,clr);
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
	}

	public void useCard(String squareType, String color) {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		
		if(squareType.equals("Railroad")) {
			for(Player p: MonopolyGameController.getPlayers()) {
				for(Square r: p.getProperties()) {
					if(r instanceof RailroadSquare && ((RailroadSquare) r).getNumberOfTrainDepots()!=0) {
						((RailroadSquare) r).decrementDepot();
						break;
					}
				}
			}
		}else {
			for(Player p: MonopolyGameController.getPlayers()) {
				for(DeedSquare d: p.getColoredOnes(color)) {
					d.downgradeFrom(d.getCurrentBuilding());
				}
			}
		}
	}
}
