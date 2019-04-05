package domain.cards.chanceActionCards;

import javax.swing.JOptionPane;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;
import ui.Facade;

public class HurricaneMakesLandfallCard extends Card {

	public HurricaneMakesLandfallCard() {
		super("chanceAction", true);
		// TODO Auto-generated constructor stub
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
		}else if (squareType.equals("DeedSquare")){
			
			for(Player p: MonopolyGameController.getPlayers()) {
				if(!p.equals(MonopolyGameController.getCurrentPlayer())) {
					for(DeedSquare d: p.getColoredOnes(color)) {
						d.downgradeFrom(d.getCurrentBuilding());
					}
				}
			}
		}
	}

	@Override
	public void useCard() {
		// TODO Auto-generated method stub
		MonopolyGameController.getInstance();
		
		Facade.getInstance().riseDialog("Please enter square type and select square color from panel, then press hurricane button");
		
		return;
		
//		String squareType="as";
//		String color="clr";
//		this.useCard(squareType,color);
	}

}
