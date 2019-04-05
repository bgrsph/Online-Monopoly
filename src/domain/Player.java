package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import domain.cards.Card;
import domain.squares.Square;
import domain.squares.propertySquares.DeedSquare;
import domain.squares.railroadSquares.RailroadSquare;
import domain.squares.utilitySquares.UtilitySquare;

public class Player implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	/**
	 * 
	 */
	private String name;
	private int balance;
	private int inJail;
	private ArrayList<Card> cards;
	private Pawn pawn;
	private boolean isBankrupt;
	private int direction;
	private ArrayList<Square> properties;
	private int numberOfOwnedUtility;
	private int numberOfOwnedRailroad;
	private int currentSquareIndex;
	private boolean specialMove;
	private HashMap<String, Integer> colorGroup= new HashMap <String, Integer>(){{
				put("dark green", 0);
				put("yellow",0);
				put("damson",0);
				put("black",0);
				put("brown",0);
				put("blue",0);
				put("light green",0);
				put("cream",0);
				put("light blue",0);
				put("light yellow",0);
				put("grey",0);
				put("white",0);
				put("light pink",0);
				put("pink",0);
				put("red",0);
				put("carmine",0);
				put("earth",0);
				put("orange",0);
				put("green",0);
				put("olive",0);
			}};



 

	public Player(String name, int startingBalance, ArrayList<Card> cards, Pawn pawn) {
		this.name = name;
		this.balance = startingBalance;
		if(cards==null) this.cards = new ArrayList<Card>();
		else this.cards=cards;
		this.pawn = pawn;
		this.properties= new ArrayList<Square>();
		this.currentSquareIndex = 0;
		this.direction = 1; //-1 is reverse direction
		this.numberOfOwnedRailroad=0;
		this.numberOfOwnedUtility=0;
		this.inJail=0;
		this.isBankrupt = false;
		
	}
	
	 
	 
	@Override
	public String toString() {
		
		
		return "\nPlayer Name: " + name + "\n" +
				"Balance: " + balance + "\n" +
				"Cards:" + cards + "\n" +
				"CurrentSqIndex" + currentSquareIndex +
				"Pawn Name: " + pawn + "\n------------------\n" ;
	}
	
	/**
	 * @requires -
	 * @modifies currentSquareIndex
	 * @effects Sets the currentSquareIndex fied of the Player to the param currentSquareIndex.
	 * 
	 */

	public void setCurrentSquareIndex(int currentSquareIndex) {
		this.currentSquareIndex = currentSquareIndex;
	}
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the current square index of this Player.
	 * 
	 */
	
	
	public int getCurrentSquareIndex() {
		
		return this.currentSquareIndex;
	}
	
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the properties of this Player.
	 * 
	 */
	
	public ArrayList<Square> getProperties() {
		return this.properties;
	}
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the balance of this Player.
	 * 
	 */
	
	public int getBalance() {
		return balance;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns if this Player is in the jail. It will help later to decided whether this Player can play in the turn.
	 * 
	 */
	
	public boolean isInJail() {
		if(this.inJail==0) return false;
		else return true;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the cards of this Player.
	 * 
	 */
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the rollThreeCards of this Player.
	 * 
	 */
	/*
	@SuppressWarnings("null")
	public ArrayList<RollThreeCard> getRollThreeCards() {
		ArrayList<RollThreeCard> rtc= null;
		for(int i=0;i<cards.size();i++) {
			if(cards.get(i).getType()=="rollThree") {
				rtc.add((RollThreeCard) cards.get(i));
			}
		}
		return rtc;
	}
*/

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the pawn of this Player.
	 * 
	 */
	public Pawn getPawn() {
		return pawn;
	}

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the direction of this Player.
	 * 
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @requires -
	 * @modifies balance field of this Player
	 * @effects Increases the balance field of the PLayer with the param amountMoney.
	 * 
	 */
	public void increaseMoney(int amountMoney) {
		balance += amountMoney;
	}
	

	/**
	 * @requires -
	 * @modifies -
	 * @effects Indicates that the Player has ended its turn via prompting a message.
	 * 
	 */
	public void allowReleaseTurnOnly(boolean turn) {
		System.out.println("Turn Ended.");
	}

	/**
	 * @requires -
	 * @modifies balance field of this Player
	 * @effects Decreases the balance field of the PLayer with the param amountMoney.
	 * 
	 */
	
	public void decreaseMoney(int amountMoney) {
		if(checkBalance(amountMoney)) {
			balance -= amountMoney;
		} else {
			this.setBankruptcy(true);
			Logger.getInstance().notifyAll(this.getName()+"is bankrupted");
			Logger.getInstance().notifyAll("Now, can't exit the game as a punishment, will watch entire game while others are having fun!");
		}
	}

	/**
	 * @requires Player have should enogh balance to have the buying process done and also deed has to be unowned.
	 * @modifies balance and properties field of this Player
	 * @effects Decreases the balance field of the Player with the price field of the desired DeedSquare and extends the properties field
	 * 			of the Player with the param d1 if the buying process successfully done.
	 * 
	 */
	public void buy(Square s) {
		if(s instanceof DeedSquare) {
			this.buyDeed((DeedSquare) s);
		}else if(s instanceof UtilitySquare) {
			this.buyUtility((UtilitySquare) s);
		}else if(s instanceof RailroadSquare) {
			this.buyRailroad((RailroadSquare) s);
		}
	}
	
	public void buyDeed(DeedSquare d1) {
		if(d1.getOwner()==null) {
			int x=d1.getPrice();
			if(checkBalance(x)) {
					MonopolyGameController.getInstance();
					this.decreaseMoney(x);
					d1.setOwner(this);
					this.properties.add(d1);
					int current= this.colorGroup.get(d1.getColor());
					this.colorGroup.put(d1.getColor(), current+1);
					Logger.getInstance().notifyAll(this.getName() + " bought " + d1.getName());
			}
		}else Logger.getInstance().notifyAll(d1.getName() + " has been already bought.");
	}
	
	public void buyUtility(UtilitySquare s1) {
		if(s1.getOwner()==null) {
			int x=s1.getPrice();
			if(checkBalance(x)) {
				MonopolyGameController.getInstance();
				this.decreaseMoney(x);
				s1.setOwner(this);
				this.numberOfOwnedUtility++;
				this.properties.add(s1);
				Logger.getInstance().notifyAll(this.getName() + " bought " + s1.getName());
			}else Logger.getInstance().notifyAll(s1.getName() + " has been already bought.");
		}
	}
	
	public void buyRailroad(RailroadSquare r1) {
		if(r1.getOwner()==null) {
			int x=r1.getPrice();
			if(checkBalance(x)) {
				MonopolyGameController.getInstance();
				this.decreaseMoney(x);
				r1.setOwner(this);
				this.numberOfOwnedRailroad++;
				this.properties.add(r1);
				Logger.getInstance().notifyAll(this.getName() + " bought " + r1.getName());
			}else Logger.getInstance().notifyAll(r1.getName() + " has been already bought.");
		}
	}
	
	public void demolishSkyscraper(String color) {
		ArrayList<DeedSquare> coloredOnes=new ArrayList<>();
		coloredOnes=this.getColoredOnes(color);
		boolean b= true;
		for(DeedSquare d: coloredOnes) {
			if(d.getCurrentBuilding()!="skyscraper") b=false;
		}
		
		if(b) {
			DeedSquare s = null;
			for(DeedSquare d: coloredOnes) {
				d.downgradeFrom(d.getCurrentBuilding());
				Logger.getInstance().notifyAll("Mortgage operation for skyscraper is done");
				s=d;
			}
			s.getOwner().increaseMoney(s.getSkyScraperPrice()/2);
		}
	}
	
	
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Compares the balance field with the param a, returns true if value of the balance is greater than the param a, otherwise false.
	 * 
	 * 
	 */	
	
	public boolean checkBalance(int a) {
		return this.balance>=a;
	}
	
	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the numberOfOwnedUtility of this Player.
	 * 
	 */
	
	public int getNumberOfOwnedUtility() {
		return numberOfOwnedUtility;
	}

	/**
	 * @requires -
	 * @modifies numberOfOwnedUtility field of this Player
	 * @effects Sets the numberOfOwnedUtility fied of the Player to the param numberOfOwnedRailroad.
	 * 
	 */

	public void setNumberOfOwnedUtility(int numberOfOwnedUtility) {
		this.numberOfOwnedUtility = numberOfOwnedUtility;
	}
	
	

	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the numberOfOwnedRailroad of this Player.
	 * 
	 */

	public int getNumberOfOwnedRailroad() {
		return numberOfOwnedRailroad;
	}

	/**
	 * @requires -
	 * @modifies numberOfOwnedRailroad field of this Player
	 * @effects Sets the numberOfOwnedRailroad fied of the Player to the param numberOfOwnedRailroad.
	 * 
	 */


	public void setNumberOfOwnedRailroad(int numberOfOwnedRailroad) {
		this.numberOfOwnedRailroad = numberOfOwnedRailroad;
	}


	/**
	 * @requires -
	 * @modifies -
	 * @effects Returns the name of this Player.
	 * 
	 */

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	/**
	 * @requires Param board to get the square.
	 * @modifies -
	 * @effects Returns the Square related with the currentSquareIndex of the Player by using information expert pattern via the param board.
	 * 
	 */

	public Square getCurrentSquare(Board board) {
		
		
		return board.getSquareList().get(this.getCurrentSquareIndex());
		
	}

	public boolean repOk() {
		if (this.name != null && this.balance >= 0 && this.pawn != null && this.properties != null 
				&& this.currentSquareIndex >= 0  && this.cards != null) {
				return true;
		}

		return false;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public void setInJail(int inJail) {
		this.inJail = inJail;
	}
	
	public void decrementInJail() {
		if(this.inJail>0) this.inJail--;
	}

	public void nowInJail() {
		 this.inJail=3;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public int jailRemaining() {
		return this.inJail;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}


	//automatically sets the direction in to reverse
	public void reversetDirection() {
		if(this.getDirection()==1)
		this.direction = -1;
		else this.direction=1;
	}
	public void setDirection(int i) {
		this.direction=i;
	}



	public void setProperties(ArrayList<Square> properties) {
		this.properties = properties;
	}
	
	public String majorityOrMonopoly(String color) {
		int x= this.colorGroup.get(color);
		String mo="Majority Ownership";
		String mp="Monopoly";
		switch(color) {
		case "damson": case "blue":
			if (x==2) return mp;
			break;
		case "yellow": case "black": case "brown": case "light blue": case "grey" : case "white": case "light pink": case "pink": case "red": case "earth": case "orange": case "green":
			if(x==2) return mo;
			else if (x==3) return mp;
			break;
		case "dark green": case "light green": case "cream": case "light yellow": case "carmine": case "olive":
			if(x==3) return mo;
			else if (x==4) return mp;
			break;
		}
		return "Invalid color";
	}
	
	public boolean avaibleForSkyscraper(String color) {
		ArrayList<DeedSquare> coloredOnes=new ArrayList<>();
		boolean b=true;
		if(this.majorityOrMonopoly(color)=="Monopoly") {
			coloredOnes= this.getColoredOnes(color);
			for(DeedSquare d: coloredOnes) {
				if(d.getNumberOfHotels()==0) {
					b=false;
					break;
				}
			}
		} else b=false;
		return b;
	}
	
	

	public void buildSkyscraper(String color) {
		if(this.avaibleForSkyscraper(color)) {
			ArrayList<DeedSquare> coloredOnes=new ArrayList<>();
			coloredOnes=this.getColoredOnes(color);
			for(DeedSquare d: coloredOnes) {
				d.setCurrentBuilding("skyscraper");	
				d.setNumberOfHotels(0);
				d.setNumberOfSkyScrapers(1);
				this.decreaseMoney(d.getSkyScraperPrice());
			}
		}
	}
	
	
	

	public ArrayList<DeedSquare> getColoredOnes(String color){
		ArrayList<DeedSquare> coloredOnes=new ArrayList<>();
		for(Square d: this.properties) {
			if(d instanceof DeedSquare) {
				if(((DeedSquare) d).getColor()==color) {
					coloredOnes.add((DeedSquare) d);
				}
			}
		}
		return coloredOnes;
		
	}


	public HashMap<String, Integer> getColorGroup() {
		return colorGroup;
	}



	public void setColorGroup(HashMap<String, Integer> colorGroup) {
		this.colorGroup = colorGroup;
	}

	public void payRent(Square s) {
		MonopolyGameController.getInstance();
		int rent=0;
		if(s instanceof DeedSquare) {
			rent=((DeedSquare)s).getCurrentRent();
				this.decreaseMoney(rent);
				((DeedSquare)s).getOwner().increaseMoney(rent);
		}else if(s instanceof UtilitySquare) {
			rent=((UtilitySquare)s).getCurrentRent(this.numberOfOwnedUtility)*MonopolyGameController.getCup().getTotalFaceValue();
			
				this.decreaseMoney(rent);
				((UtilitySquare)s).getOwner().increaseMoney(rent);
	
		}else if(s instanceof RailroadSquare) {
			int x[]=((RailroadSquare)s).getRent();
			rent=x[this.getNumberOfOwnedRailroad()-1];
			if(((RailroadSquare)s).getNumberOfTrainDepots()==1) rent*=2;
			
				this.decreaseMoney(rent);
				((RailroadSquare)s).getOwner().increaseMoney(rent);
	}
		Logger.getInstance().notifyAll(this.getName() + " paid " + rent + "dollars for rent");
	}



	public boolean isSpecialMove() {
		return specialMove;
	}



	public void setSpecialMove(boolean specialMove) {
		this.specialMove = specialMove;
	}



	public boolean isInOuterTrack() {
		int sqIndex = this.getCurrentSquareIndex();
		
		return sqIndex > 63 && sqIndex < 120;
	}



	public boolean isInCenterTrack() {
		int sqIndex = this.getCurrentSquareIndex();
		return sqIndex >= 0 && sqIndex < 40 ;
	}



	public Card getOwnedCardByName(String selectedCardName) {
		
		List<Card> result = getCards().stream()              
                .filter(card -> card.getName().equals(selectedCardName))     
                .collect(Collectors.toList());  
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
		
	}
	
	public void setBankruptcy(boolean bankrupt) {
		this.isBankrupt=bankrupt;
	}
	
	public boolean getBankruptcy() {
		return this.isBankrupt;
	}
	

}
