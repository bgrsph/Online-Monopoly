package domain.bots;

import java.util.ArrayList;

import domain.MonopolyGameController;
import domain.Pawn;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;
import domain.squares.utilitySquares.UtilitySquare;
import ui.MonopolyGameFrame;

public class Bot extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BotStrategy botStrategy;
	private String botType;
	private BotFactory bF = new BotFactory();

	public Bot(String name, int startingBalance, ArrayList<Card> cards, Pawn pawn, String botType) {
		super(name, startingBalance, cards, pawn);
		// TODO Auto-generated constructor stub
		this.botType=botType;
	}
	
	public void playBot() {
		MonopolyGameController.getInstance();
		try {
			MonopolyGameController.rollDice();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int currentSqIndex = MonopolyGameController.getCurrentPlayer().getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSqIndex);
		this.botBuyStrategy();
		if(currentSquare instanceof DeedSquare) {
			if(((DeedSquare) currentSquare).isOwned()) {
				this.payRent(currentSquare);
			} else {
				this.botBuyStrategy();
			}
		}
		else if(currentSquare instanceof RailroadSquare) {
			if(((RailroadSquare) currentSquare).isOwned()) {
				this.payRent(currentSquare);
			} else {
				this.botBuyStrategy();
			}
		}
		else if(currentSquare instanceof UtilitySquare) {
			if(((UtilitySquare) currentSquare).isOwned()) {
				this.payRent(currentSquare);
			} else {
				this.botBuyStrategy();
			}
		} else currentSquare.landedOn();
		
		if(MonopolyGameController.getCup().isSpecial()) {
			//MonopolyGameController.moveSpecial(this, MonopolyGameController.getCup().getTotalFaceValue());
			MonopolyGameController.getInstance().specialMoveButtonPressed();
		}

		this.botBuyStrategy();
		this.botMortgageStrategy();
		
//	
//		if(MonopolyGameController.getDoubleCounter()>=1) {
//			while(MonopolyGameController.getDoubleCounter()<3) {
//				try {
//					MonopolyGameController.rollDice();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if(currentSquare instanceof DeedSquare) {
//					if(((DeedSquare) currentSquare).isOwned()) {
//						this.payRent(currentSquare);
//					} else {
//						this.botBuyStrategy();
//					}
//				}
//				else if(currentSquare instanceof RailroadSquare) {
//					if(((RailroadSquare) currentSquare).isOwned()) {
//						this.payRent(currentSquare);
//					} else {
//						this.botBuyStrategy();
//					}
//				}
//				else if(currentSquare instanceof UtilitySquare) {
//					if(((UtilitySquare) currentSquare).isOwned()) {
//						this.payRent(currentSquare);
//					} else {
//						this.botBuyStrategy();
//					}
//				} else currentSquare.landedOn();
//				
//				if(MonopolyGameController.getCup().isSpecial()) {
//					//MonopolyGameController.moveSpecial(this, MonopolyGameController.getCup().getTotalFaceValue());
//					MonopolyGameController.getInstance().specialMoveButtonPressed();
//				}
//			}
//			this.botBuyStrategy();
//			this.botMortgageStrategy();
//		}
		
//		MonopolyGameFrame.getInstance().getEndTurnButton().setEnabled(true);
//		MonopolyGameFrame.getInstance().getEndTurnButton().doClick();
		
		MonopolyGameController.allowCurrentPlayerToEndTurn();
		MonopolyGameController.setDoubleCounter(0);
		
			
				
	}
	
	public void botBuyStrategy() {
		BotStrategy bst = (BotStrategy) bF.getBotType(botType);
		bst.buy(this);
	}
	
	public void botMortgageStrategy() {
		BotStrategy bst = (BotStrategy) bF.getBotType(botType);
		bst.mortgage(this);
	}
	
	public void botUseCardStrategy() {
		BotStrategy bst = (BotStrategy) bF.getBotType(botType);
		bst.useCard(this);
	}

	public void forceEndTurn() {
		MonopolyGameFrame.getInstance().getEndTurnButton().setEnabled(true);
		MonopolyGameFrame.getInstance().getEndTurnButton().doClick();
		
	}


}
